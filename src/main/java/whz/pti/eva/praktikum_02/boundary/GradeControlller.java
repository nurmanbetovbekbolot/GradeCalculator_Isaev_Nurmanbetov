package whz.pti.eva.praktikum_02.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "grades.html";
    }
}
