package hwthree.local.demo.controller;

import hwthree.local.demo.data.dto.ProfessorDto;
import hwthree.local.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/api/v1/university")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfessorController {
    //의존성 주입
    private ProfessorService professorService;


    @Autowired
    public ProfessorController(ProfessorService professorService) {this.professorService = professorService;
    }

    @GetMapping(value = "/professor/{professorId}")
    public ProfessorDto getProfessor(@PathVariable int professorId) {

        return professorService.getProfessor(professorId);
    }

    @PostMapping(value = "/professor")
    public ProfessorDto createProfessor(@RequestBody ProfessorDto professorDto) {
        int professorId = professorDto.getProfessorId();
        String professorName = professorDto.getProfessorName();

        return professorService.saveProfessor(professorId, professorName);
    }

    //pk인 id로 식별하여 교수 이름 바꾸기
    @PutMapping(value = "/professor/edit/{professorId}")
    public ProfessorDto editProfessor(@PathVariable int professorId, @RequestBody ProfessorDto professorDto) {

        return professorService.editProfessor(professorId, professorDto);
    }

    @DeleteMapping(value = "/professor/delete/{professorId}")
    public String deleteProfessor(@PathVariable int professorId) {
        return professorService.deleteProfessor(professorId);
    }

}
