package com.konkov.spring.mvc.controllers;

import com.konkov.spring.mvc.entity.Employee;
import com.konkov.spring.mvc.services.EmployeeService;
import jakarta.validation.Valid;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String showFirstView(Model model) {
        model.addAttribute("AllPeopleAttribute", employeeService.getAllEmployees());
        return "employee/firstEmpView";
    }



    @GetMapping("/details/{id}")
    public String showEmpDetails(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmpById(id);

       // Hibernate.initialize(employee.getBooks());

        model.addAttribute("getOneEmployeeAttribute", employee);
        model.addAttribute("books", employee.getBooks());

        return "employee/show_details";
    }



    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/add_employee";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/add_employee";
        } else {
            employeeService.saveEmployee(employee);
            return "redirect:/employee";
        }

    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getEmpById(id));
        return "employee/edit_employee";
    }

    @PostMapping("/updateInfo")
    public String updateEmployee(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit_employee";
        } else {
            employeeService.updateEmployee(employee);
            return "redirect:/employee";
        }

    }

    @PostMapping("/deleteInfo/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

}
