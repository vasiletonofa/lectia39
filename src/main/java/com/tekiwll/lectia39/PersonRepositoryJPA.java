package com.tekiwll.lectia39;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepositoryJPA extends JpaRepository<Person, Integer> {

    List<Person> findAllByName(String name);

    List<Person> findAllByNameAndSurname(String name, String surname);

}
