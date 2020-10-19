package whz.pti.eva.praktikum_02.service;

import whz.pti.eva.praktikum_02.domain.Grade;

import java.util.List;

/**
 * The interface GradeService service.
 * In this interface we define all methods
 *
 * @author Isaev A. Nurmanbetov B.
 */
public interface GradeService {

    /**
     * Method listAllGrades which returns list all grades.
     *
     * @return the list of type Grade
     */
    List<Grade> listAllGrades();

    /**
     * Method addGrade for adding new grades
     * Method takes to arguments
     *
     * @param lecture the lecture
     * @param grade   the grade
     */
    void addGrade(String lecture, String grade);

    /**
     * Method calculateAverage for calculating averages of grades
     *
     * @return average number of grades in type of double
     */
    double calculateAverage();
}
