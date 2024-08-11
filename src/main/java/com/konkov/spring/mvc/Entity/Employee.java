package com.konkov.spring.mvc.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Employee {

    private int id;
    @Size(min = 2, message = "name must be minimum 2 symbols")
    private String name;

    @Size(min = 2, message = "Surname must be minimum 2 symbols")
    private String surname;
    @Min(value = 0, message = "Age can not be negative number")
    private int age;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
