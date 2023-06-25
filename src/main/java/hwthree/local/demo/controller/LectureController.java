package hwthree.local.demo.controller;

import hwthree.local.demo.data.dto.LectureDto;
import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.data.dto.StudentDto;
import hwthree.local.demo.data.entity.LectureEntity;
import hwthree.local.demo.data.repository.LectureRepository;
import hwthree.local.demo.service.LectureService;
import hwthree.local.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/university")
@CrossOrigin(origins = "http://localhost:3000")
public class LectureController {
    private LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {this.lectureService = lectureService;}

    //subject명으로 찾기
    @GetMapping("/lecture")
    public List<LectureDto> getLecture(@RequestParam String subject) {
        return lectureService.getLecture(subject);
    }

    @PostMapping(value = "/lecture")
    public void createLecture(@RequestBody LectureDto lectureDto) {
        String subject = lectureDto.getSubject();
        int professorId = lectureDto.getProfessor_id();
        int studentId = lectureDto.getStudent_id();

        lectureService.saveLecture(subject, professorId, studentId);
    }

    //과목명 수정
   @PutMapping(value = "/lecture/edit/{o_subjectName}")
    public void editLecture(@PathVariable String o_subjectName, @RequestBody Map<String, String> newLectureName) {
        String newName = newLectureName.get("newsubject");
        System.out.println(o_subjectName);
        System.out.println(newName);

        lectureService.editLecture(o_subjectName, newName);
    }

    @DeleteMapping(value = "lecture/delete/{subjectName}")
    public void deleteLecture(@PathVariable String subjectName) {
        lectureService.deleteLecture(subjectName);
    }

}
