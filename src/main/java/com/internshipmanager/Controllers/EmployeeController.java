package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.AuthCredentials;
import com.internshipmanager.Entities.Employee;
import com.internshipmanager.Entities.NewEmployee;
import com.internshipmanager.Repositories.AuthCredentialsRepository;
import com.internshipmanager.Repositories.EmployeeRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthCredentialsRepository authCredentialsRepository;

    @GetMapping
    public List<Employee> all() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @PostMapping
    public Employee addOne(@RequestBody NewEmployee newEmployee) {
        Employee employee = new Employee();
        employee.setEmail(newEmployee.getEmail());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setOffice(newEmployee.getOffice());
        employee.setCity(newEmployee.getCity());
        employee =  employeeRepository.save(employee);

        AuthCredentials authCredentials = new AuthCredentials();
        authCredentials.setId(employee.getId());
        authCredentials.setEmail(employee.getEmail());
        authCredentials.setPasswordHash(newEmployee.getPasswordHash());
        authCredentialsRepository.save(authCredentials);

        return employee;
    }
}