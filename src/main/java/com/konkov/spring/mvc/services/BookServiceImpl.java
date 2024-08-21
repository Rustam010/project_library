package com.konkov.spring.mvc.services;

import com.konkov.spring.mvc.entity.Book;
import com.konkov.spring.mvc.entity.Employee;
import com.konkov.spring.mvc.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }


    @Transactional
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void assignBookToEmployee(int bookId, Employee employee) {
        //Назначаем владельца книге
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book = optionalBook.orElse(null);
        book.setEmployee(employee);
        bookRepository.save(book);

        //Назначаем книгу владельцу
        if(employee.getBooks() != null){
            employee.getBooks().add(book);
        } else{
            List<Book> books = new ArrayList<>();
            books.add(book);
            employee.setBooks(books);
        }
    }

    @Transactional
    @Override
    public void releaseBookFromEmp(int bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        book.setEmployee(null);
        bookRepository.save(book);
    }
}
