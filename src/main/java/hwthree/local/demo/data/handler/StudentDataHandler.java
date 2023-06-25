package hwthree.local.demo.data.handler;

import hwthree.local.demo.data.entity.StudentEntity;

import java.sql.Timestamp;

public interface StudentDataHandler {
    StudentEntity getStudentEntity(int studentId);
    StudentEntity saveStudentEntity(int studentId, String studentName, Timestamp admission_date);
    StudentEntity editStudentNameEntity(int studentId, String newStudentName);
    StudentEntity editStudentDateEntity(int studentId, Timestamp newStudentDate);

    String deleteStudentEntity(int studentId);

}
