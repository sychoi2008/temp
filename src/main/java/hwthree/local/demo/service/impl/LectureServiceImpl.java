package hwthree.local.demo.service.impl;

import hwthree.local.demo.data.dto.LectureDto;
import hwthree.local.demo.data.entity.LectureEntity;
import hwthree.local.demo.data.handler.LectureDataHandler;
import hwthree.local.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    LectureDataHandler lectureDataHandler;

    @Autowired
    public LectureServiceImpl(LectureDataHandler lectureDataHandler) {this.lectureDataHandler = lectureDataHandler;}

    @Override
    public List<LectureDto> getLecture(String subjectName) {
        List<LectureEntity> lectureEntity = lectureDataHandler.getSubjectLectureEntity(subjectName);
        List<LectureDto> lld = new ArrayList<LectureDto>();

        for (int i=0; i<lectureEntity.size(); i++) {
            LectureEntity le = lectureEntity.get(i);
            LectureDto ld = new LectureDto(le.getId(), le.getSubject(),le.getProfessor_id(),le.getStudent_id());
            lld.add(ld);
        }
        return lld;
    }

    @Override
    public void saveLecture(String subject, int professorId, int studentId) {
        lectureDataHandler.saveLectureEntity(subject, professorId, studentId);

    }

    @Override
    public void editLecture(String o_subjectName, String d_newLectureName) {
        lectureDataHandler.editLectureEntity(o_subjectName, d_newLectureName);
    }

    @Override
    public void deleteLecture(String subjectName) {
        lectureDataHandler.deleteLectureEntity(subjectName);
    }
}
