package com.tpconnects.dynamodbexample;

import com.tpconnects.dynamodbexample.entity.Person;
import com.tpconnects.dynamodbexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @GetMapping
    public String endpoint() {
        return "person endpoint";

    }

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{personId}")
    public Person getPerson(@PathVariable(value = "personId") String personId) {
        return personRepository.findPerson(personId);
    }

    @DeleteMapping
    public String deletePerson(@RequestBody Person person) {
        return personRepository.deltePerson(person);
    }
}
