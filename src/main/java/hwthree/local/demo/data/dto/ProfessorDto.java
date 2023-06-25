package hwthree.local.demo.data.dto;

import hwthree.local.demo.data.entity.ProfessorEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ProfessorDto {
    private int professorId;
    private String professorName;

}
