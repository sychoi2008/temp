package hwthree.local.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.data.dto.StudentDto;
import hwthree.local.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/university")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {this.studentService = studentService;}

    @GetMapping("/student/{studentId}")
    public StudentDto getStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/student")
    public StudentDto createStudent(@RequestBody @JsonFormat(pattern="yyyy-MM-dd") StudentDto studentDto) {
        int studentId = studentDto.getStudentId();
        String studentName = studentDto.getStudentName();
        Timestamp admission_date = studentDto.getAdmission_date();

        return studentService.createStudent(studentId, studentName, admission_date);
    }

    @PutMapping(value = "/student/edit/name/{studentId}")
    public StudentDto editStudentName(@PathVariable int studentId, @RequestBody Map<String, String> newnameMap) {
        String newName = newnameMap.get("studentName");
        return studentService.editStudentName(studentId, newName);
    }

    @PutMapping(value = "/student/edit/date/{studentId}")
    public StudentDto editStudentDate(@PathVariable int studentId, @RequestBody @JsonFormat(pattern="yyyy-MM-dd")
    Map<String, Timestamp> newStudentDate) {
        Timestamp newtimedate = newStudentDate.get("adDate");
        //String d_newStudentDate = newStudentDate.replaceAll("\\\"","");
        return studentService.editStudentDate(studentId, newtimedate);
    }

    @DeleteMapping(value = "/student/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }


}
