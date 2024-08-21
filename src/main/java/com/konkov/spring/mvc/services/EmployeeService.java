package com.konkov.spring.mvc.services;

import com.konkov.spring.mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmpById(int id);
    public void saveEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(int id);
}
