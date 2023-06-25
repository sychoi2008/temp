package hwthree.local.demo.data.dao.impl;

import hwthree.local.demo.data.dao.ProfessorDAO;
import hwthree.local.demo.data.entity.ProfessorEntity;
import hwthree.local.demo.data.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorDAOImpl implements ProfessorDAO {

    ProfessorRepository professorRepository;

    @Autowired
    public ProfessorDAOImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    @Override
    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity) {
        professorRepository.save(professorEntity);
        return professorEntity;
    }

    @Override
    public ProfessorEntity getProfessor(int professorId) {
        ProfessorEntity professorEntity = professorRepository.getReferenceById(professorId);
        return professorEntity;
    }

    @Override
    public ProfessorEntity editProfessor(ProfessorEntity professorEntity) { //파라미터로 새로운 이름이 들어간 엔티티 박스를 받음
//        //getReferenceById로 변경 전의 professorEntity를 담는다
//        ProfessorEntity professorEntity = professorRepository.getReferenceById(professorId);
//        //setter로 새로운 교수 이름을 주입
//        professorEntity.setName(newProfessorName);
        //DB에 저장
        professorRepository.save(professorEntity);
        //바뀐 교수 이름이 들어간 professorEntity를 return 한다.
        return professorEntity;
    }

    @Override
    public String deleteProfessor(int professorId) {
        ProfessorEntity professorEntity = professorRepository.getReferenceById(professorId);
        professorRepository.deleteById(professorId);
        return professorEntity.getId() + " " + professorEntity.getName() + " 교수님의 정보를 삭제했습니다.";
    }
}