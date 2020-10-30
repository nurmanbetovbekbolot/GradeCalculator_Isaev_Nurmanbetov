package whz.pti.eva.praktikum_02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import whz.pti.eva.praktikum_02.domain.GradeRepository;
import whz.pti.eva.praktikum_02.service.GradeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * GradeCalculatorIsaevNurmanbetovApplicationTests class for JUnit testing.
 * We test here all our methods
 *
 * @author Isaev A. Nurmanbetov B.
 */
@SpringBootTest
class GradeCalculatorIsaevNurmanbetovApplicationTests {

    /**
     * The Grade repository.
     */
    @Autowired
    GradeRepository gradeRepository;

    /**
     * The Grade service.
     */
    @Autowired
    GradeServiceImpl gradeServiceImpl;

    /**
     * Context loads.
     */
    @Test
    void contextLoads() {
    }

    /**
     * Method to clean database before each test
     */
    @BeforeEach
    void cleanDatabase(){
        gradeRepository.deleteAll();
    }

    /**
     * Calculate average.
     */
    @Test
    void calculateAverage() {
        gradeServiceImpl.addGrade("Mathe", "3.0");
        gradeServiceImpl.addGrade("Englisch", "2.5");
        gradeServiceImpl.addGrade("EvA", "1.5");
        gradeServiceImpl.addGrade("Wiss. Arbeiten", "1.0");
        double a = gradeServiceImpl.calculateAverage();
        assertThat(a).isEqualTo(2.0);
    }

    /**
     * Add grade.
     */
    @Test
    void addGrade() {
        gradeServiceImpl.addGrade("Mathe", "2.0");
        assertThat(gradeRepository.count()).isEqualTo(1);
    }

    /**
     * List all grades.
     */
    @Test
    void listAllGrades() {
        gradeServiceImpl.addGrade("Mathe", "2.0");
        assertThat(gradeServiceImpl.listAllGrades()).isNotEmpty();
    }

}
