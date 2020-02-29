package ru.skorikov.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.skorikov.domain.Unit;
import ru.skorikov.repository.UnitRepository;
import ru.skorikov.service.UnitService;
import ru.skorikov.service.UnitServiceIMPL;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Home controller.
 */
@Controller
public class HelloController {

    @Autowired
    private UnitRepository repository;

    private UnitService service = new UnitServiceIMPL();

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String units( Map<String, Object> model) {
        Iterable<Unit> units = repository.findAll();
        model.put("units", units);
        return "hello";
    }

    @PostMapping("/hello")
    public String add(@RequestParam String name,
                      @RequestParam Integer count,
                      @RequestParam String password,
                      @RequestParam String description, Map<String, Object> model){

        Unit unit = new Unit();
        unit.setName(name);
        unit.setCount(count);
        unit.setPassword(password);
        unit.setDescription(description);
        unit.setIsactive(true);
        Date date = new Date(System.currentTimeMillis());
        unit.setCreatedate(date);

        repository.save(unit);

        return "redirect:/hello";
    }

    @PostMapping("/file")
    public String addFromFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!(file == null)) {

            File temp = File.createTempFile("temp", ".csv");
            temp.deleteOnExit();
            file.transferTo(temp);

            List<Unit> list = service.getUnitsList(temp);
            repository.saveAll(list);

            temp.delete();
        }
        return "redirect:/hello";
    }

}

