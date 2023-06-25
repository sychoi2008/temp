package hwthree.local.demo.service.impl;

import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.data.entity.ProfessorEntity;
import hwthree.local.demo.data.handler.ProfessorDataHandler;
import hwthree.local.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    ProfessorDataHandler professorDataHandler;

    @Autowired
    public ProfessorServiceImpl(ProfessorDataHandler professorDataHandler) {
        this.professorDataHandler = professorDataHandler;
    }
    @Override
    public ProfessorDto saveProfessor(int professorId, String professorName) {
        ProfessorEntity professorEntity = professorDataHandler.saveProfessorEntity(professorId, professorName);

        ProfessorDto professorDto = new ProfessorDto(professorEntity.getId(), professorEntity.getName());
        return professorDto;
    }

    @Override
    public ProfessorDto getProfessor(int professorId) {
        ProfessorEntity professorEntity = professorDataHandler.getProfessorEntity(professorId);

        ProfessorDto professorDto = new ProfessorDto(professorEntity.getId(), professorEntity.getName());
        return professorDto;
    }

    @Override
    public ProfessorDto editProfessor(int professorId, ProfessorDto professorDto) {
        ProfessorEntity professorEntity = professorDataHandler.editProfessorEntity(professorId, professorDto);

        ProfessorDto editedProfessorDto = new ProfessorDto(professorEntity.getId(), professorEntity.getName());
        return editedProfessorDto;
    }

    @Override
    public String deleteProfessor(int professorId) {
        return professorDataHandler.deleteProfessorEntity(professorId);
    }


}
