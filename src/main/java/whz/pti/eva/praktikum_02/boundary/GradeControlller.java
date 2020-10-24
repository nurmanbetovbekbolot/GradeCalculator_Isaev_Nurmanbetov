package whz.pti.eva.praktikum_02.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.service.GradeService;

import java.util.List;

/**
 * This is a GradeControlller. Which binds Model and View.
 * Here we handle http request.
 *
 * @author Isaev A. Nurmanbetov B.
 */
@Controller
public class GradeControlller {
    @Autowired
    private GradeService gradeService;

    /**
     * This method handles all requests which go through /grades.
     * Method returns all grades as a list from database.
     *
     * @param model the model
     * @return grades.html
     */
    @RequestMapping("/grades")
    public String listAllGrades(Model model) {
        List<Grade> gradeList = gradeService.listAllGrades();
        Double averageOfGrades = gradeService.calculateAverage();
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("averageOfGrades",averageOfGrades);
        return "grades";
    }

    /**
     * This method handles all requests which go through /add.
     * Type of this method is Post. This method addes new Grade(lecture, grade).
     *
     * @param lecture the lecture
     * @param grade   the grade
     * @param model   the model
     * @return redirects to grades.html
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@RequestParam String lecture, @RequestParam String grade, Model model) {
        model.addAttribute("lecture", lecture);
        model.addAttribute("grade", grade);
        List<Grade> gradeList = gradeService.listAllGrades();
        model.addAttribute("gradeList", gradeList);
        gradeService.addGrade(lecture, grade);
        return "redirect:grades";

    }
}
