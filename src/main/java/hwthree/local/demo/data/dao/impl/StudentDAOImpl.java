package hwthree.local.demo.data.dao.impl;

import hwthree.local.demo.data.dao.StudentDAO;
import hwthree.local.demo.data.entity.StudentEntity;
import hwthree.local.demo.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StudentDAOImpl implements StudentDAO {

    StudentRepository studentRepository;

    @Autowired
    public StudentDAOImpl(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    @Override
    public StudentEntity getStudent(int studentId) {
        //찾는 학생 entity를 JPA의 getReferenceById를 통해 가져온다. 그리고 그것을 Entity에 넣어주고 return 해준다.
        StudentEntity studentEntity = studentRepository.getReferenceById(studentId);

        return studentEntity;
    }

    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
        //넣은 학생 엔티티 보여주기
        return studentEntity;
    }

    @Override
    public String deleteStudent(int studentId) {
        StudentEntity studentEntity = studentRepository.getReferenceById(studentId);
        studentRepository.deleteById(studentId);
        return studentEntity.getId() + " " + studentEntity.getName() + " 학생의 정보를 삭제했습니다.";
    }

    @Override
    public StudentEntity editStudentName(int studentId, String newStudentName) {
        //admission_date를 가져오기 위함
        StudentEntity studentEntity_date = studentRepository.getReferenceById(studentId);
        StudentEntity studentEntity_new = new StudentEntity(studentId, newStudentName, studentEntity_date.getAdmission_date());

        studentRepository.save(studentEntity_new);

        return studentEntity_new;
    }

    @Override
    public StudentEntity editStudentDate(int studentId, Timestamp newStudentDate) {
        //name을 가져오기 위함
        StudentEntity studentEntity_name = studentRepository.getReferenceById(studentId);
        StudentEntity studentEntity_new = new StudentEntity(studentId, studentEntity_name.getName(), newStudentDate);

        studentRepository.save(studentEntity_new);

        return studentEntity_new;
    }
}
