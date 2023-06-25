package hwthree.local.demo.data.dao;

import hwthree.local.demo.data.entity.LectureEntity;

import java.util.List;

public interface LectureDAO {
    void saveLecture(LectureEntity le);

    List<LectureEntity> getLectureBySubject(String subjectName);

    void editLecture(String o_subjectName, String d_newLectureName);
    void deleteLecture(String subjectName);
}
