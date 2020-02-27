package ru.skorikov.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Home controller.
 */
@Controller
public class HelloController {
    /**
     * Mapping to "/".
     * @return home view.
     */
    @GetMapping("/hello")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World")
                                       String name, Map<String, Object> model) {
        model.put("name", name);
        return "hello";
    }
}

