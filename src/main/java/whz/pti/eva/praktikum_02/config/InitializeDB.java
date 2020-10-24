package whz.pti.eva.praktikum_02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.domain.GradeRepository;

import javax.annotation.PostConstruct;

@Component
public class InitializeDB {
    @Autowired
    GradeRepository gradeRepository;

    @PostConstruct
    public void init(){
        Grade grade1= new Grade("Mate","2.0");
        Grade grade2= new Grade("Englisch","1.0");
        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
    }
}