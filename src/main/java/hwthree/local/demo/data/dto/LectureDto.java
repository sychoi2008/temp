package hwthree.local.demo.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class LectureDto {
    private int lectureId;
    private String subject;
    private int professor_id;
    private int student_id;

    public LectureDto(String sub, int pid, int sid) {
        this.subject = sub;
        this.professor_id = pid;
        this.student_id = sid;
    }
}
