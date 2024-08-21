package com.konkov.spring.mvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в пределах от 2 до 30 символов")
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть в пределах от 2 до 30 символов")
    private String author;

    @Column(name = "publishyear")
    @Max(value = 2024, message = "Дата публикации должна быть не позднее 2024 года")
    private int publishYear;


    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;


    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
