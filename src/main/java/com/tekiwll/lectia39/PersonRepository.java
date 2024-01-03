package com.tekiwll.lectia39;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    int idCount = 0;

    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
       return personList;
    }

    public void updatePerson(Person person, int id) {
        Person p = personList.stream()
                .filter(pers -> pers.getId() == id)
                .findFirst().get();

        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setSurname(person.getSurname());
    }

    public Person createPerson(Person person) {

        boolean exists = personList.stream()
                        .filter(p -> p.getName().equals(person.getName()))
                        .anyMatch(p -> p.getSurname().equals(person.getSurname()));

        if (exists) {
            throw new RuntimeException("Duplicate Person");
        }

        person.setId(++idCount);
        personList.add(person);
        return person;
    }

    public void deletePerson(int id) {
        personList = personList.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
    }

    public List<Person> getPersonByName(String name, String surname) {
        return personList.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getSurname().equals(surname))
                .collect(Collectors.toList());
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
       return personList.stream()
                .filter(p -> p.getName().equals(name))
                .filter(p -> p.getSurname().equals(surname))
                .findFirst().orElseThrow(() -> new RuntimeException("Nu a fost gasita perosana data") );
    }
}
