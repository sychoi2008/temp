package hwthree.local.demo.service.impl;

import hwthree.local.demo.data.dto.StudentDto;
import hwthree.local.demo.data.entity.StudentEntity;
import hwthree.local.demo.data.handler.StudentDataHandler;
import hwthree.local.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class StudentServiceImpl implements StudentService {
    //서비스 클래스에서는 Entity를 만들고, DTO를 전달한다.
    StudentDataHandler studentDataHandler;

    @Autowired
    public StudentServiceImpl(StudentDataHandler studentDataHandler) {this.studentDataHandler = studentDataHandler;}

    @Override
    public StudentDto getStudent(int studentId) {
        //알맞은 학생 entity를 가져옴
        StudentEntity studentEntity = studentDataHandler.getStudentEntity(studentId);

        StudentDto studentDto = new StudentDto(studentEntity.getId(), studentEntity.getName(),studentEntity.getAdmission_date());
        return studentDto;
    }

    @Override
    public StudentDto createStudent(int studentId, String studentName, Timestamp admission_date) {
        StudentEntity studentEntity = studentDataHandler.saveStudentEntity(studentId, studentName, admission_date);
        StudentDto studentDto = new StudentDto(studentEntity.getId(), studentEntity.getName(), studentEntity.getAdmission_date());
        return studentDto;
    }

    @Override
    public StudentDto editStudentName(int studentId, String newStudentName) {
        StudentEntity studentEntity = studentDataHandler.editStudentNameEntity(studentId, newStudentName);
        StudentDto studentDto = new StudentDto(studentEntity.getId(), studentEntity.getName(), studentEntity.getAdmission_date());
        return studentDto;
    }

    @Override
    public StudentDto editStudentDate(int studentId, Timestamp newStudentDate) {
        StudentEntity studentEntity = studentDataHandler.editStudentDateEntity(studentId, newStudentDate);
        StudentDto studentDto = new StudentDto(studentEntity.getId(), studentEntity.getName(), studentEntity.getAdmission_date());
        return studentDto;
    }

    @Override
    public String deleteStudent(int studentId) {
        return studentDataHandler.deleteStudentEntity(studentId);
    }
}
