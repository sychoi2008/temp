package hwthree.local.demo.data.handler.impl;

import hwthree.local.demo.data.dao.LectureDAO;
import hwthree.local.demo.data.entity.LectureEntity;
import hwthree.local.demo.data.handler.LectureDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureDataHandlerImpl implements LectureDataHandler {
    LectureDAO lectureDAO;

    @Autowired
    public LectureDataHandlerImpl(LectureDAO lectureDAO) {this.lectureDAO = lectureDAO;}

    @Override
    public List<LectureEntity> getSubjectLectureEntity(String subjectName) {
        return lectureDAO.getLectureBySubject(subjectName);
    }

    @Override
    public void saveLectureEntity(String subject, int professorId, int studentId) {
        //새로운 professorEntity 박스를 만든다.
        LectureEntity le = new LectureEntity(subject, professorId, studentId);

        //그 박스를 DAO에게 넘겨준다.
        //professorDAO.saveProfessor은 ProfessorEntity를 return함.
        lectureDAO.saveLecture(le);
    }

    @Override
    public void editLectureEntity(String o_subjectName, String d_newLectureName) {
        lectureDAO.editLecture(o_subjectName, d_newLectureName);
    }

    @Override
    public void deleteLectureEntity(String subjectName) {
        lectureDAO.deleteLecture(subjectName);
    }
}
