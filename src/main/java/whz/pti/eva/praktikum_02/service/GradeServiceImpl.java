package whz.pti.eva.praktikum_02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(GradeServiceImpl.class);

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> listAllGrades() {
        log.info("GradeService: Method 'listAllGrades' our list = " + gradeRepository.findAll());
        return gradeRepository.findAll();
    }

    @Override
    public void addGrade(String lecture, String grade) {
        log.info("GradeService: Method 'addGrade' to add new Grade = " + lecture + " " + grade);
        if (Double.parseDouble(grade) >= 1.0 && Double.parseDouble(grade) <= 5.0) {
            Grade newGrade = new Grade();
            newGrade.setGrade(grade);
            newGrade.setLecture(lecture);
            gradeRepository.save(newGrade);
        }
    }

    @Override
    public double calculateAverage() {
        log.info("GradeService: Method 'calculateGrade' to calculate average of grades");

        double sumOfGrades;
        if (listAllGrades().size() > 0) {
            sumOfGrades = listAllGrades().stream()
                    .map((x) -> Double.parseDouble(x.getGrade()))
                    .reduce((double) 0, Double::sum);
        } else {
            return 0;
        }
        log.info("GradeService: Method 'calculateGrade' average of grades = " + sumOfGrades / listAllGrades().size());
        return sumOfGrades / listAllGrades().size();
    }
}
