package whz.pti.eva.praktikum_02.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.domain.GradeRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * We use this class to add some grades to database
 */
@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    /**
     * The Grade repository.
     */
    @Autowired
    GradeRepository gradeRepository;

    /**
     * Init method
     * where we create 2 grades and save them
     */
    @PostConstruct
    public void init(){
        log.info("Initialize database ...");
        Grade grade1= new Grade("Mate","2.0");
        Grade grade2= new Grade("Englisch","1.0");
        gradeRepository.save(grade1);
        gradeRepository.save(grade2);
        log.info("To database added new grade "+grade1);
        log.info("To database added new grade "+grade2);
    }

    /**
     * PreDestroy method
     * where we clear our database
     */
    @PreDestroy
    public void clearDatabase(){
        log.info("Clear database ...");
        gradeRepository.deleteAll();
        log.info("All rows in database were cleared ...");
    }
}