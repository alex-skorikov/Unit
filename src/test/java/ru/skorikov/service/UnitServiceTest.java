package ru.skorikov.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.skorikov.domain.Unit;
import ru.skorikov.repository.UnitRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Test unit service class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceTest {
    /**
     * Repository.
     */
    @MockBean
    private UnitRepository repository;
    /**
     * Service.
     */
    @Autowired
    private UnitService service;

    /**
     * Test service find all units.
     */
    @Test
    public void findAll() {
        Unit unit = new Unit();
        unit.setName("name");
        List<Unit> list = new ArrayList();
        list.add(unit);
        when(this.repository.findAll()).thenReturn(list);

        Assert.assertThat(list, is(service.findAll()));
    }

    /**
     * Test service save unit.
     */
    @Test
    public void save() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.save(unit);
        verify(this.repository, times(1)).save(unit);
    }

    /**
     * Test service save all units.
     */
    @Test
    public void saveAll() {
        Unit unit = new Unit();
        unit.setName("name");
        List<Unit> list = new ArrayList();
        list.add(unit);
        this.service.saveAll(list);
        verify(this.repository, times(1)).saveAll(list);
    }

    /**
     * Test sevece delete unit.
     */
    @Test
    public void delete() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.delete(unit);
        verify(this.repository, times(1)).delete(unit);
    }

    /**
     * Test find unit byid.
     */
    @Test
    public void findUnitById() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.save(unit);
        when(this.repository.findUnitById(any(Integer.class))).thenReturn(unit);
        Assert.assertThat("name", is(this.service.findUnitById(1).getName()));

    }
}