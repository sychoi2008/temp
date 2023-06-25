package hwthree.local.demo.data.dao;

import hwthree.local.demo.data.entity.StudentEntity;

import java.sql.Timestamp;

public interface StudentDAO {
    StudentEntity getStudent(int studentId);
    StudentEntity saveStudent(StudentEntity studentEntity);

    String deleteStudent(int studentId);

    StudentEntity editStudentName(int studentId, String newStudentName);

    StudentEntity editStudentDate(int studentId, Timestamp newStudentDate);
}
