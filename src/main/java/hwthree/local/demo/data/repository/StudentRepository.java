package hwthree.local.demo.data.repository;

import hwthree.local.demo.data.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
