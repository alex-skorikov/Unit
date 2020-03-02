package ru.skorikov.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.skorikov.domain.Unit;
import ru.skorikov.service.UnitService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test unit controller.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnitControllerTest {
    /**
     * Mock mvc.
     */
    @Autowired
    private MockMvc mvc;
    /**
     * Controller.
     */
    @Autowired
    private UnitController controller;
    /**
     * Unit service.
     */
    @MockBean
    private UnitService service;

    /**
     * Test delete unit.
     * @throws Exception exception.
     */
    @Test
    public void delete() throws Exception {
        assertThat(mvc).isNotNull();
        this.mvc.perform(get("/delete/{id}", "1")
                .accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(view().name("redirect:/hello"));
    }

    /**
     * Test get unit for update.
     * @throws Exception exception.
     */
    @Test
    public void getUnitForUpdate() throws Exception {
        Unit unit = new Unit();
        unit.setId(1);
        unit.setName("name");
        unit.setCount(55);
        unit.setPassword("pass");
        unit.setDescription("desk");
        unit.setIsactive(false);
        given(this.service.findUnitById(any(Integer.class)))
                .willReturn(unit);
        this.mvc.perform(get("/update/{id}", "1"))
                .andDo(print())
                .andExpect(view().name("update"));
    }

    /**
     * Test update unit and redirect /home.
     * @throws Exception exception.
     */
    @Test
    public void update() throws Exception {
        Unit unit = new Unit();
        given(this.service.findUnitById(any(Integer.class)))
                .willReturn(unit);
        this.mvc.perform(post("/update/{id}", "1")
                .param("name", "name")
                .param("count", "200")
                .param("password", "pass")
                .param("description", "description")
                .param("activ", "true"))
                .andDo(print())
                .andExpect(view().name("redirect:/hello"));
    }
}