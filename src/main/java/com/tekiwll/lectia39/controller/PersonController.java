package com.tekiwll.lectia39.controller;

import com.tekiwll.lectia39.Person;
import com.tekiwll.lectia39.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController             // Controller
@RequestMapping("/person")
public class PersonController { // GET, POST, PUT, DELETE, PATCH          -> http://localhost:8080/person/delete/3

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public List<Person> getPersonList() {
       return personService.getPersonList();
    }

    @GetMapping
    public List<Person> getPersonByName(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        List<Person> person;
        try {
            person =  personService.getPersonByNameAndSurname(name, surname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.ok(person);
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable int id) {
        personService.updatePerson(person, id);
    }

    @PatchMapping("/patch/{id}")
    public void patchPerson(@RequestBody Person person, @PathVariable int id) {
        personService.patchPerson(person, id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPerson(@RequestBody Person person) {
        try {
          Person p =  personService.createPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nu am reusit sa cream persoana");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

}
