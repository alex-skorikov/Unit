package ru.skorikov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skorikov.domain.Unit;
import ru.skorikov.service.UnitService;

import java.util.Map;


@Controller
public class UnitController {

    @Autowired
    private UnitService service;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {

        Unit unit = new Unit();
        unit.setId(Integer.parseInt(id));
        this.service.delete(unit);

        return "redirect:/hello";
    }

    @GetMapping("/update/{id}")
    public String getUnitForUpdate(@PathVariable("id") String id,
                                   Map<String, Object> model) {
        Unit unit = this.service.findUnitById(Integer.parseInt(id));
        model.put("unit", unit);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id,
                         @RequestParam String name,
                         @RequestParam Integer count,
                         @RequestParam String password,
                         @RequestParam String description,
                         @RequestParam Boolean activ) {

        Unit unit = this.service.findUnitById(Integer.parseInt(id));
        unit.setName(name);
        unit.setCount(count);
        unit.setPassword(password);
        unit.setDescription(description);
        unit.setIsactive(activ);
        this.service.save(unit);

        return "redirect:/hello";
    }

}
