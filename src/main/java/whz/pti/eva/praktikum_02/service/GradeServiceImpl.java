package whz.pti.eva.praktikum_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.domain.GradeRepository;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> listAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void addGrade(String lecture, String grade) {
        Grade newGrade = new Grade();
        newGrade.setGrade(grade);
        newGrade.setLecture(lecture);
        gradeRepository.save(newGrade);
    }

    @Override
    public double calculateAverage() {
        List<Grade> allGrades = listAllGrades();
        double sumOfGrades = 0;
        for (Grade grade : allGrades) {
            double temp = Double.parseDouble(grade.getGrade());
            sumOfGrades += temp;
        }
        return sumOfGrades / allGrades.size();
    }
}
