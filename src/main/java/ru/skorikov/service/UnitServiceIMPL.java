package ru.skorikov.service;

import ru.skorikov.domain.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UnitServiceIMPL implements UnitService {


    @Override
    public List<Unit> getUnitsList(File file) {
        List<Unit> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
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

}
