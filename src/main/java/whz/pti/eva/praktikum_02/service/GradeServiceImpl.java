package whz.pti.eva.praktikum_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.domain.GradeRepository;

import java.util.List;

/**
 * The class GradeServiceImpl that implements GradeService interface.
 * Here we place our business logic
 *
 * @author Isaev A. Nurmanbetov B.
 */
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

        double sumOfGrades = listAllGrades().stream()
                .map((x)->Double.parseDouble(x.getGrade()))
                .reduce((double) 0, Double::sum);

        return sumOfGrades / listAllGrades().size();
    }
}
