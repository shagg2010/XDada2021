package com.yadas.web.rest.controller;

import com.yadas.web.rest.controller.exceptions.EmployeeNotFoundException;
import com.yadas.web.rest.model.Employee;
import com.yadas.web.rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employee")
    public Employee newEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employee/{id}")
    public Employee replaceEmployee(@RequestBody Employee updatedEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setRole(updatedEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    updatedEmployee.setId(id);
                    return repository.save(updatedEmployee);
                });
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
