package hwthree.local.demo.data.dao.impl;

import hwthree.local.demo.data.dao.LectureDAO;
import hwthree.local.demo.data.entity.LectureEntity;
import hwthree.local.demo.data.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureDAOImpl implements LectureDAO {
    LectureRepository lectureRepository;

    @Autowired
    public LectureDAOImpl(LectureRepository lectureRepository) {this.lectureRepository = lectureRepository;}

    @Override
    public void saveLecture(LectureEntity le) {
        lectureRepository.saveDBLecture(le.getSubject(), le.getProfessor_id(), le.getStudent_id());
    }

    @Override
    public List<LectureEntity> getLectureBySubject(String subjectName) {
        return lectureRepository.findbySubjectALL(subjectName);
    }

    @Override
    public void editLecture(String o_subjectName, String d_newLectureName) {
        lectureRepository.editLectureName(o_subjectName, d_newLectureName);
    }

    @Override
    public void deleteLecture(String subjectName) {
        lectureRepository.deleteLectureName(subjectName);
    }


}
