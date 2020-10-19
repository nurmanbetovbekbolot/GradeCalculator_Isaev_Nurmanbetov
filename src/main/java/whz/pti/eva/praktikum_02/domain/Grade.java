package whz.pti.eva.praktikum_02.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The entity Grade.
 * The class Grade has three attributes id, lecture and grade
 * In database will be created corresponding table
 *
 * @author Isaev A. Nurmanbetov B.
 */
@Entity
public class Grade {

    @Id
    @GeneratedValue
    private Integer id;

    private String lecture;
    private String grade;

    /**
     * Instantiates a new Grade.
     */
    public Grade() {
    }

    /**
     * Instantiates a new Grade.
     *
     * @param lecture the lecture
     * @param grade   the grade
     */
    public Grade(String lecture, String grade) {
        this.lecture = lecture;
        this.grade = grade;
    }

    /**
     * Instantiates a new Grade.
     *
     * @param id      the id
     * @param lecture the lecture
     * @param grade   the grade
     */
    public Grade(Integer id, String lecture, String grade) {
        this.id = id;
        this.lecture = lecture;
        this.grade = grade;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Gets lecture.
     *
     * @return the lecture
     */
    public String getLecture() {
        return lecture;
    }


    /**
     * Sets lecture.
     *
     * @param lecture the lecture
     */
    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
