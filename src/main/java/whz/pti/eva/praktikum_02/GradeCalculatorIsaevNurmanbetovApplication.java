package whz.pti.eva.praktikum_02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main class that runs program
 *
 * @author Isaev A. Nurmanbetov B.
 */
@SpringBootApplication
public class GradeCalculatorIsaevNurmanbetovApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GradeCalculatorIsaevNurmanbetovApplication.class, args);
    }

    /**
     * Method init type of CommandLineRunner
     * that prints message to console
     *
     * @return the command line runner
     */
    @Bean
    CommandLineRunner init() {
        return (evt) -> System.out.println("Hallo Welt");
    }

}
