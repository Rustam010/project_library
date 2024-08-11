package com.konkov.spring.mvc.controllers;

import com.konkov.spring.mvc.DAO.BookDAO;
import com.konkov.spring.mvc.DAO.EmployeeDAO;
import com.konkov.spring.mvc.Entity.Book;
import com.konkov.spring.mvc.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDAO bookDAO;
    private final EmployeeDAO employeeDAO;

    @Autowired
    public BookController(BookDAO bookDAO, EmployeeDAO employeeDAO) {
        this.bookDAO = bookDAO;
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping()
    public String showAllBooks(Model model) {
        model.addAttribute("allBooks", bookDAO.getAllBooks());
        return "book/all_books_view";
    }

    @RequestMapping("/details/{id}")
    public String showBookDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));

        model.addAttribute("allEmployees", employeeDAO.getAllEmployees());

        Book book = bookDAO.getBookById(id);
        Employee bookOwner = null;
        if (book.getEmployeeId() != null) {
            bookOwner = employeeDAO.getEmpByID(book.getEmployeeId());
        }
        model.addAttribute("bookOwner", bookOwner);


        return "book/show_details";
    }

    @RequestMapping("/addBook")
    public String addNewBook(@ModelAttribute("book") Book book) {
        return "book/add_book_view";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookDAO.createBook(book);
        return "redirect:/book";
    }


    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));
        return "book/edit_book";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookDAO.updateBook(book);
        return "redirect:/book";
    }


    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
        return "redirect:/book";
    }

       /*  Выше - основа CRUD приложения, дальше логика присваивания книг людям_______________________________________
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
    */


    // Обработка назначения книги
    @RequestMapping("/assignBook")
    public String assignBook(@ModelAttribute("bookId") int bookId, @ModelAttribute("employeeId") int employeeId,
                             Model model) {
        bookDAO.assignBookToEmployee(bookId, employeeId);
        return "redirect:/book/details/" + bookId;
    }

    @RequestMapping("/releaseBook")
    public String releaseBook(@ModelAttribute("bookId") int bookId) {
        bookDAO.releaseBookFromEmp(bookId);
        return "redirect:/book/details/" + bookId;
    }

}
