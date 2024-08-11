package com.konkov.spring.mvc.controllers;

import com.konkov.spring.mvc.DAO.EmployeeDAO;
import com.konkov.spring.mvc.Entity.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String showFirstView(Model model) {
        model.addAttribute("AllPeopleAttribute", employeeDAO.getAllEmployees());
        return "employee/firstEmpView";
    }

    @RequestMapping("/details/{id}")
    public String showEmpDetails(@PathVariable("id") int id, Model model) {
        Employee employee = employeeDAO.getEmpByID(id);
        model.addAttribute("getOneEmployeeAttribute", employee);

        model.addAttribute("books", employeeDAO.getBookByEmpId(id));

        return "employee/show_details";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/add_employee";
    }

//    @RequestMapping("/addNewEmployee")      Этот метод, в данном сулчае, делает тоже само что и метод выше
//    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
//
//        return "add_employee";
//    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/add_employee";
        } else {
            employeeDAO.saveEmployee(employee);
            return "redirect:/employee";
        }

    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeDAO.getEmpByID(id));
        return "employee/edit_employee";
    }

    @PostMapping("/updateInfo")
    public String updateEmployee(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit_employee";
        } else {
            employeeDAO.updateEmployee(employee);
            return "redirect:/employee";
        }

    }

    @RequestMapping("/deleteInfo/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeDAO.deleteEmployee(id);
        return "redirect:/employee";
    }

//    @RequestMapping("/second")
//    public String showSecondView(Model model) {
//        model.addAttribute("employeeDetailsAttribute", new Employee());
//        return "ask_emp_details";
//    }

//    @RequestMapping("/third")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("namek");
//        String empAge = request.getParameter("agek");
//
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("ageAttribute", empAge);
//
//        return "show_details";
//    }

//    @RequestMapping("/third")
//    public String showEmpDetails(@RequestParam("namek") String empName,
//                                 @RequestParam("agek") String empAge,
//                                 Model model) {
//
//
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("ageAttribute", empAge);
//
//        return "show_details";
//    }

}
