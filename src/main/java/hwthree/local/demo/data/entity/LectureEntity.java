package hwthree.local.demo.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lecture")
@NoArgsConstructor
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subject;
    private int professor_id;
    private int student_id;

    public LectureEntity (String sub, int pid, int sid) {
        this.subject = sub;
        this.professor_id = pid;
        this.student_id = sid;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
