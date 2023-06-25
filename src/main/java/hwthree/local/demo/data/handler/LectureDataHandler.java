package hwthree.local.demo.data.handler;

import hwthree.local.demo.data.dto.LectureDto;
import hwthree.local.demo.data.entity.LectureEntity;

import java.util.List;

public interface LectureDataHandler {
    List<LectureEntity> getSubjectLectureEntity(String subjectName);
    void saveLectureEntity(String subject, int professorId, int studentId);

    void editLectureEntity(String o_subjectName, String d_newLectureName);

    void deleteLectureEntity(String subjectName);
}
