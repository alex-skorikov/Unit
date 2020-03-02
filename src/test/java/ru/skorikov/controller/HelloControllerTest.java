package ru.skorikov.controller;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.skorikov.domain.Unit;
import ru.skorikov.service.UnitService;

import java.io.File;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test hello controller.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    /**
     * Mock Mvc.
     */
    @Autowired
    private MockMvc mvc;
    /**
     * Hello controller.
     */
    @Autowired
    private HelloController controller;
    /**
     * Unit service.
     */
    @MockBean
    private UnitService service;

    /**
     * Test get home page.
     * @throws Exception exception.
     */
    @Test
    public void whenGetHomeThenReturnHomePage() throws Exception {
        assertThat(mvc).isNotNull();
        this.mvc.perform(get("/")
                .accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("home")
                );
    }

    /**
     * Test home page? return all units.
     * @throws Exception exception.
     */
    @Test
    public void whenGetHelloPagaThenReturnUnits() throws Exception {
        Unit unit = new Unit();
        unit.setId(12);
        unit.setName("name");
        unit.setCount(55);
        unit.setDescription("desk");
        unit.setIsactive(false);
        given(this.service.findAll())
                .willReturn(new ArrayList<Unit>(Lists.newArrayList(unit)));
        this.mvc.perform(get("/hello")
                .accept(MediaType.TEXT_HTML))
                .andExpect(
                        status().isOk())
                .andExpect(view()
                        .name("hello")
                );
    }

    /**
     * Test add unit and redirect home page.
     * @throws Exception exception.
     */
    @Test
    public void whenAddUnitThenRedirectHome() throws Exception {
        this.mvc.perform(post("/hello")
                .param("name", "name")
                .param("count", "200")
                .param("password", "pass")
                .param("description", "description"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/hello"));
    }

    /**
     * Test add unit fron file.
     * @throws Exception exception.
     */
    @Test
    public void addFromFile() throws Exception {
        Unit unit = new Unit();
        unit.setId(12);
        unit.setName("name");
        unit.setCount(55);
        unit.setDescription("desk");
        unit.setIsactive(false);
        given(this.service.getUnitsList(any(File.class)))
                .willReturn(new ArrayList<Unit>(Lists.newArrayList(unit)));

        MockHttpServletRequestBuilder multipart = multipart("/file")
                .file("file", "123".getBytes());

        this.mvc.perform(multipart)
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/hello"));
    }
}