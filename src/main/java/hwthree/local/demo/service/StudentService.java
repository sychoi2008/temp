package hwthree.local.demo.service;

import hwthree.local.demo.data.dto.StudentDto;
import jakarta.persistence.Table;

import java.sql.Timestamp;

public interface StudentService {
    StudentDto getStudent(int studentId);
    StudentDto createStudent(int studentId, String studentName, Timestamp admission_date);

    StudentDto editStudentName(int studentId, String newStudentName);
    StudentDto editStudentDate(int studentId, Timestamp newStudentDate);



    String deleteStudent(int studentId);

}
