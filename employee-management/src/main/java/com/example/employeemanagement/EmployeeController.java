package com.example.employeemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/new")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/new")
    public String addEmployee(@ModelAttribute Employee employee) {
        employees.add(employee);
        return "redirect:/employees";
    }

    // EmployeeController.java
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        employees.removeIf(employee -> employee.getId() == id);
        return "redirect:/employees";
    }

}
