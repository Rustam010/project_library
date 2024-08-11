package com.konkov.spring.mvc.DAO;

import com.konkov.spring.mvc.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book where id =?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void createBook(Book book) {
        jdbcTemplate.update("INSERT INTO book (name, author, publishyear) VALUES (?, ?, ?)",
                book.getName(), book.getAuthor(), book.getPublishYear());
    }

    public void updateBook(Book book) {
        jdbcTemplate.update("UPDATE book SET name = ?, author = ?, publishYear = ? WHERE id = ?",
                book.getName(), book.getAuthor(), book.getPublishYear(), book.getId());
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

   /*  Выше - основа CRUD приложения, дальше - логика присваивания книг людям_______________________________________
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
    */


    public void assignBookToEmployee(int bookId, int employeeId) {
        jdbcTemplate.update("UPDATE book SET employee_id=? WHERE id=?", employeeId, bookId);
    }

    public void releaseBookFromEmp(int bookId){
        jdbcTemplate.update("UPDATE book SET employee_id= null WHERE id=?", bookId);
    }

}
