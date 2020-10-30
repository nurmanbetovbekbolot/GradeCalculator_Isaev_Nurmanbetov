package whz.pti.eva.praktikum_02;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import whz.pti.eva.praktikum_02.domain.Grade;
import whz.pti.eva.praktikum_02.service.GradeServiceImpl;

import java.util.List;

@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringBootTest
public class GradeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private GradeServiceImpl gradeService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
        when(gradeService.calculateAverage()).thenReturn(1.5);
        when(gradeService.listAllGrades()).thenReturn(List.of(new Grade(), new Grade()));
    }

    @Test
    public void testListAllGrades() throws Exception {
        mockMvc.perform(get("/grades")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("grades"))
                .andExpect(model().attribute("gradeList", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void testAddGrades() throws Exception {

        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("lecture", "Math")
                .param("grade", "2.0")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("grades"));

    }
}
