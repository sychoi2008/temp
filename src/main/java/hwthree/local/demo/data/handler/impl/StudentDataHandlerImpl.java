package hwthree.local.demo.data.handler.impl;

import hwthree.local.demo.data.dao.StudentDAO;
import hwthree.local.demo.data.entity.StudentEntity;
import hwthree.local.demo.data.handler.StudentDataHandler;
import hwthree.local.demo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StudentDataHandlerImpl implements StudentDataHandler {
    StudentDAO studentDAO;

    @Autowired
    public StudentDataHandlerImpl(StudentDAO studentDAO) {this.studentDAO = studentDAO;}

    @Override
    public StudentEntity getStudentEntity(int studentId) {
        return studentDAO.getStudent(studentId);
    }

    @Override
    public StudentEntity saveStudentEntity(int studentId, String studentName, Timestamp admission_date) {
        //받은 엔티티를 다시 다른 엔티티 인스턴스에 넣어주기
        StudentEntity studentEntity = new StudentEntity(studentId, studentName, admission_date);
        //DAO에 그것을 전달하고 return 값으로 넣은 엔티티 받기
        return studentDAO.saveStudent(studentEntity);
    }

    @Override
    public StudentEntity editStudentNameEntity(int studentId, String newStudentName) {
        return studentDAO.editStudentName(studentId, newStudentName);
    }

    @Override
    public StudentEntity editStudentDateEntity(int studentId, Timestamp newStudentDate) {
        return studentDAO.editStudentDate(studentId, newStudentDate);
    }

    @Override
    public String deleteStudentEntity(int studentId) {
        return studentDAO.deleteStudent(studentId);
    }
}
