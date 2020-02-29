package ru.skorikov.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.skorikov.domain.Unit;
import ru.skorikov.repository.UnitRepository;
import ru.skorikov.service.UnitService;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UnitRepository repository;

    @MockBean
    private UnitService service;

    @Test
    void whenGetHomeThenReturnHomePage() throws Exception {
        this.mvc.perform(
                get("/").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("home")
        );
    }

    @Test
    void whenGetHelloPagaThenReturnUnits() throws Exception {
        Unit unit = new Unit();
        unit.setId(12);
        unit.setName("name");
        unit.setCount(55);
        unit.setDescription("desk");
        unit.setIsactive(false);
        given(
                this.repository.findAll()
        ).willReturn(
                new ArrayList<Unit>(
                        Lists.newArrayList(unit)
                )
        );
        this.mvc.perform(
                get("/hello").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("hello")
        );
    }

    @Test
    void add() {
    }

    @Test
    void addFromFile() {
    }
}