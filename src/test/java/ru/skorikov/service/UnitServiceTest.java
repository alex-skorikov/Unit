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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceTest {

    @MockBean
    private UnitRepository repository;
    @Autowired
    private UnitService service;


    @Test
    public void findAll() {
        Unit unit = new Unit();
        unit.setName("name");
        List<Unit> list = new ArrayList();
        list.add(unit);
        when(this.repository.findAll()).thenReturn(list);

        Assert.assertThat(list, is(service.findAll()));
    }

    @Test
    public void save() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.save(unit);
        verify(this.repository, times(1)).save(unit);
    }

    @Test
    public void saveAll() {
        Unit unit = new Unit();
        unit.setName("name");
        List<Unit> list = new ArrayList();
        list.add(unit);
        this.service.saveAll(list);
        verify(this.repository, times(1)).saveAll(list);
    }

    @Test
    public void delete() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.delete(unit);
        verify(this.repository, times(1)).delete(unit);
    }

    @Test
    public void findUnitById() {
        Unit unit = new Unit();
        unit.setName("name");
        this.service.save(unit);
        when(this.repository.findUnitById(any(Integer.class))).thenReturn(unit);
        Assert.assertThat("name", is(this.service.findUnitById(1).getName()));

    }
}