package hwthree.local.demo.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class StudentDto {
    private int studentId;
    private String studentName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp admission_date;
}
