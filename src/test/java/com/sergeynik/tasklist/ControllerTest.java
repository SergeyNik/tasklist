package com.sergeynik.tasklist;

import com.sergeynik.tasklist.model.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Контроллер Controller, ")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@Transactional
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("который должен учитывать пагинацию и сортировку, 2 страница")
    void getTasks() throws Exception {
        em.persist(new Task(
                null,
                "first",
                "description"
        ));
        em.flush();
        mockMvc.perform(get("/tasks")
                .param("sort", "header,DESC")
                .param("page", "0")
                .param("size", "3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].header", is("first")));
    }
}
