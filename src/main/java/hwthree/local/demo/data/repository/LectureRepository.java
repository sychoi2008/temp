package hwthree.local.demo.data.repository;

import hwthree.local.demo.data.entity.LectureEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRepository extends JpaRepository<LectureEntity, String> {
    @Query(value =  "SELECT * from lecture l where l.subject = ?1", nativeQuery = true)
    List<LectureEntity> findbySubjectALL(String subject);

    @Query(value = "INSERT INTO lecture (subject, professor_id, student_id) values(?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void saveDBLecture(String subject, int professorId, int studentId);

    @Query(value = "UPDATE lecture SET subject= :d_newLectureName WHERE subject= :o_subjectName", nativeQuery = true)
    @Modifying
    @Transactional
    void editLectureName(@Param("o_subjectName") String o_subjectName, @Param("d_newLectureName") String d_newLectureName);

    @Query(value = "DELETE from lecture where subject = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteLectureName(String subjectName);
}
