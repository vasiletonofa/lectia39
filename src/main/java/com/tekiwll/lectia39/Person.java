package com.tekiwll.lectia39;

import jakarta.persistence.*;

@Entity
public class Person {


    public Person() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int idnp;

    @Column
    private String orasul;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "varsta")
    private int age;

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdnp() {
        return idnp;
    }

    public void setIdnp(int idnp) {
        this.idnp = idnp;
    }

    public String getOrasul() {
        return orasul;
    }

    public void setOrasul(String orasul) {
        this.orasul = orasul;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
