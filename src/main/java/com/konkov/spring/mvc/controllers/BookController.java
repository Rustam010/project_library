package com.konkov.spring.mvc.controllers;

import com.konkov.spring.mvc.entity.Book;
import com.konkov.spring.mvc.entity.Employee;
import com.konkov.spring.mvc.services.BookService;
import com.konkov.spring.mvc.services.EmployeeService;
import jakarta.persistence.Table;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;
    private final EmployeeService employeeService;


    @Autowired
    public BookController(BookService bookService, EmployeeService employeeService) {
        this.bookService = bookService;
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String showAllBooks(Model model) {
        model.addAttribute("allBooks", bookService.getAllBooks());
        return "book/all_books_view";
    }

    @GetMapping("/details/{id}")
    public String showBookDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));

        model.addAttribute("allEmployees", employeeService.getAllEmployees());

        Book book = bookService.getBookById(id);
        Employee bookOwner = book.getEmployee();
        model.addAttribute("bookOwner", bookOwner);


        return "book/show_details";
    }

    @GetMapping("/addBook")
    public String addNewBook(@ModelAttribute("book") Book book) {
        return "book/add_book_view";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/book";
    }


    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));

        return "book/edit_book";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);

        return "redirect:/book";
    }


    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }

       /*  Выше - основа CRUD приложения, дальше логика присваивания книг людям_______________________________________
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
    */


    // Обработка назначения книги

    @PostMapping("/assignBook")
    public String assignBook(@ModelAttribute("bookId") int bookId, @ModelAttribute("employeeId") int employeeId,
                             Model model) {
        Employee employee = employeeService.getEmpById(employeeId);

        bookService.assignBookToEmployee(bookId, employee);

        return "redirect:/book/details/" + bookId;
    }


    @PostMapping("/releaseBook")
    public String releaseBook(@ModelAttribute("bookId") int bookId) {
        bookService.releaseBookFromEmp(bookId);
        return "redirect:/book/details/" + bookId;
    }

}
