package com.rik.regsys.data.person;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;

    public List<PersonEntity> findAll(){return new ArrayList<>(personRepository.findAll());}

    public PersonEntity findById(Long id) {
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.orElse(null);
    }

    public PersonEntity newPerson(PersonEntity person){
        System.out.println(person.toString());
        return personRepository.save(person);
    }

    public PersonEntity save(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
