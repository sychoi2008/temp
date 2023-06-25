package hwthree.local.demo.data.handler.impl;

import hwthree.local.demo.data.dao.ProfessorDAO;
import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.data.entity.ProfessorEntity;
import hwthree.local.demo.data.handler.ProfessorDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorDataHandlerImpl implements ProfessorDataHandler {

    ProfessorDAO professorDAO;

    @Autowired
    public ProfessorDataHandlerImpl(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }
    @Override
    public ProfessorEntity saveProfessorEntity(int professorId, String professorName) {
        //새로운 professorEntity 박스를 만든다.
        ProfessorEntity professorEntity = new ProfessorEntity(professorId, professorName);

        //그 박스를 DAO에게 넘겨준다.
        //professorDAO.saveProfessor은 ProfessorEntity를 return함.
        return professorDAO.saveProfessor(professorEntity);
    }

    @Override
    public ProfessorEntity getProfessorEntity(int professorId) {
        return professorDAO.getProfessor(professorId);
    }

    @Override
    public ProfessorEntity editProfessorEntity(int professorId, ProfessorDto professorDto) {
        //파라미터로 받은 새이름과 기존의 id값을 새로운 엔티티 객체의 필드값으로 넣어서 그것을 DAO에 전달한다.
        ProfessorEntity professorEntity = new ProfessorEntity(professorId, professorDto.getProfessorName());
        return professorDAO.editProfessor(professorEntity);
    }

    @Override
    public String deleteProfessorEntity(int professorId) {
        return professorDAO.deleteProfessor(professorId);
    }
}
