package hwthree.local.demo.service;

import hwthree.local.demo.data.dto.ProfessorDto;

public interface ProfessorService {
    ProfessorDto saveProfessor(int professorId, String professorName);
    ProfessorDto getProfessor(int professorId);
    ProfessorDto editProfessor(int professorId, ProfessorDto professorDto);
    String deleteProfessor(int professorId);
}
