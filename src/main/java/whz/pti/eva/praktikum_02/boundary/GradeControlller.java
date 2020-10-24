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

@Controller
public class GradeControlller {
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/grades")
    public String listAllGrades(Model model) {
        List<Grade> gradeList = gradeService.listAllGrades();
        model.addAttribute("gradeList", gradeList);
        return "grades";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@RequestParam String lecture, @RequestParam String grade, Model model) {
        model.addAttribute("lecture1", lecture);
        model.addAttribute("grade", grade);
        List<Grade> gradeList = gradeService.listAllGrades();
        model.addAttribute("gradeList", gradeList);
        gradeService.addGrade(lecture, grade);
        return "redirect:grades";

    }
}
