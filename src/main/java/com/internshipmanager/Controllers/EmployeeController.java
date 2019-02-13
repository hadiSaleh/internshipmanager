package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Employee;
import com.internshipmanager.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> all() {
        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id){
        Optional<Employee> employee = repository.findById(id);
        return employee.orElse(null);
    }

    @PostMapping()
    public Employee addOne(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }
}