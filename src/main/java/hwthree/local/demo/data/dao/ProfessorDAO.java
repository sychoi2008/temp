package hwthree.local.demo.data.dao;

import hwthree.local.demo.data.entity.ProfessorEntity;

public interface ProfessorDAO {
    ProfessorEntity saveProfessor(ProfessorEntity professorEntity);
    ProfessorEntity getProfessor(int professorId);
    ProfessorEntity editProfessor(ProfessorEntity professorEntity);
    String deleteProfessor(int professorId);
}
