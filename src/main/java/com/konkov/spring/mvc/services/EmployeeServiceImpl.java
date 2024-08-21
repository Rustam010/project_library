package com.konkov.spring.mvc.services;

import com.konkov.spring.mvc.entity.Employee;
import com.konkov.spring.mvc.repositories.EmployeeRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Employee getEmpById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            // Инициализация коллекции
            Hibernate.initialize(employee.getBooks());
        }

        return employee;

    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
