package com.rik.regsys.data.person;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
@RequestMapping("api/person")
public class PersonController {
    @Autowired
    private final PersonService personService;

    @GetMapping
    public List<PersonEntity> getPersons(){
        return personService.findAll();
    }

    @PostMapping("/new")
    public PersonEntity newPerson(@RequestBody PersonEntity person){
        return personService.newPerson(person);
    }
}
