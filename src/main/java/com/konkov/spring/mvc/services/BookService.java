package com.konkov.spring.mvc.services;

import com.konkov.spring.mvc.entity.Book;
import com.konkov.spring.mvc.entity.Employee;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);
    public void assignBookToEmployee(int bookId, Employee employee);
    public void releaseBookFromEmp(int bookId);
}
