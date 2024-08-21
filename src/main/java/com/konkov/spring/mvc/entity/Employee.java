package com.konkov.spring.mvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в пределах от 2 до 30 символов")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Поле должно быть в пределах от 2 до 30 символов")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст не должен быть отрицательным")
    private int age;

    @OneToMany(mappedBy = "employee")
    private List<Book> books;

    public Employee() {
    }

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
