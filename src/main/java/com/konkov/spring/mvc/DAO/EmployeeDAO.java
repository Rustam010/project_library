package com.konkov.spring.mvc.DAO;

import com.konkov.spring.mvc.Entity.Book;
import com.konkov.spring.mvc.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmpByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
    }

    public void saveEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (name, surname, age) VALUES (?, ?, ?)",
                employee.getName(), employee.getSurname(), employee.getAge());
    }

    public void updateEmployee(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET name = ?, surname = ?, age = ? WHERE id = ?",
                employee.getName(), employee.getSurname(), employee.getAge(), employee.getId());
    }

    public void deleteEmployee(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

       /*  Выше - основа CRUD приложения, дальше - логика присваивания книг людям_______________________________________
__________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________
    */


    public List<Book> getBookByEmpId(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE employee_id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}