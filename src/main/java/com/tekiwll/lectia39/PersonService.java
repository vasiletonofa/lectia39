package com.tekiwll.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepositoryJPA personRepository;

    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    public void updatePerson(Person person, int id) {
        Person p = personRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Nu exista persoana cu id: " + id));

        p.setName(person.getName());
        p.setIdnp(person.getIdnp());
        p.setOrasul(person.getOrasul());
        p.setAge(person.getAge());
        p.setSurname(person.getSurname());

        personRepository.save(p); // daca avem persoana cu asa id -> update,  daca nu cream persoana noua
    }

    public Person createPerson(Person person) {
       return personRepository.save(person); // se creaza un rand nou in tabela person
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> getPersonByName(String name) {
        return personRepository.findAllByName(name);
    }
//
    public List<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findAllByNameAndSurname(name, surname);
    }
//
    public void patchPerson(Person person, int id) {
        Person p = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nu exista persoana cu id: " + id));

        if(person.getIdnp() != 0) {
            p.setIdnp(person.getIdnp());
        }
        if(person.getOrasul() != null) {
            p.setOrasul(person.getOrasul());
        }
        if(person.getName() != null) {
            p.setName(person.getName());
        }
        if(person.getSurname() != null) {
            p.setSurname(person.getSurname());
        }
        if(person.getAge() != 0) {
            p.setAge(person.getAge());
        }

        personRepository.save(p);
    }
}
