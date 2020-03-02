package ru.skorikov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skorikov.domain.Unit;
import ru.skorikov.repository.UnitRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;

    public List<Unit> getUnitsList(File file) {
        List<Unit> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String string;
            while ((string = reader.readLine()) != null) {
                Unit unit = createUnit(string);
                list.add(unit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Unit createUnit(String string) {
        Unit unit = new Unit();
        String[] array = string.replaceAll("\"", "").split(";");
        unit.setName(array[0]);
        unit.setCount(Integer.parseInt(array[1]));
        unit.setPassword(array[2]);
        unit.setDescription(array[3]);
        unit.setIsactive(true);
        unit.setCreatedate(new Date(System.currentTimeMillis()));
        return unit;
    }

    public Iterable<Unit> findAll() {
        return this.repository.findAll();
    }

    public void save(Unit unit) {
        this.repository.save(unit);
    }

    public void saveAll(List<Unit> list) {
        this.repository.saveAll(list);
    }

    public void delete(Unit unit) {
        this.repository.delete(unit);
    }

    public Unit findUnitById(int parseInt) {
        return this.repository.findUnitById(parseInt);
    }
}
