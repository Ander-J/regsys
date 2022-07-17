package com.rik.regsys;

import com.rik.regsys.data.person.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebappController {
    private final PersonService personService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("persons", personService.findAll());
        return "home";
    }
}
