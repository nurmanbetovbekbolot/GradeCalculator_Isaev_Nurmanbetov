package whz.pti.eva.praktikum_02.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Integer id;

    private String lecture;
    private String grade;

    public Grade() {
    }

    public Grade(String lecture, String grade) {
        this.lecture = lecture;
        this.grade = grade;
    }

    public Grade(Integer id, String lecture, String grade) {
        this.id = id;
        this.lecture = lecture;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
