package com.tekiwll.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonList() {
        return personRepository.getPersonList();
    }

    public void updatePerson(Person person, int id) {
        personRepository.updatePerson(person, id);
    }

    public Person createPerson(Person person) {
       return personRepository.createPerson(person);
    }

    public void deletePerson(int id) {
        personRepository.deletePerson(id);
    }

    public List<Person> getPersonByName(String name, String surname) {
        return personRepository.getPersonByName(name, surname);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        return personRepository.getPersonByNameAndSurname(name, surname);
    }
}
