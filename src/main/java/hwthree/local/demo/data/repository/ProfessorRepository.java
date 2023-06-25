package hwthree.local.demo.data.repository;

import hwthree.local.demo.data.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
    //JPARepository<ProfessorEntity, Integer<- 이게 뭐꼬?>
}
