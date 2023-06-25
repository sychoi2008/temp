package hwthree.local.demo.data.handler;

import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.data.entity.ProfessorEntity;

public interface ProfessorDataHandler {
    ProfessorEntity saveProfessorEntity(int professorId, String professorName);
    ProfessorEntity getProfessorEntity(int professorId);
    ProfessorEntity editProfessorEntity(int professorId, ProfessorDto professorDto);

    String deleteProfessorEntity(int professorId);
}
