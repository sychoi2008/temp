package hwthree.local.demo.service;

import hwthree.local.demo.data.dto.LectureDto;

import java.util.List;

public interface LectureService {
    List<LectureDto> getLecture(String subjectName);

    void saveLecture(String subject, int professorId, int studentId);

    void editLecture(String o_subjectName, String d_newLectureName);

    void deleteLecture(String subjectName);
}
