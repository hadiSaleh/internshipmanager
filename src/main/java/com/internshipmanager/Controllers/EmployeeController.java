package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.AuthCredentials;
import com.internshipmanager.Entities.Employee;
import com.internshipmanager.Entities.InternshipParticipant;
import com.internshipmanager.Entities.NewEmployee;
import com.internshipmanager.Repositories.AuthCredentialsRepository;
import com.internshipmanager.Repositories.EmployeeRepository;
import com.internshipmanager.Repositories.InternshipParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthCredentialsRepository authCredentialsRepository;

    @Autowired
    private InternshipParticipantRepository internshipParticipantRepository;

    @GetMapping
    public List<Employee> all() {
        return Lists.newArrayList(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @GetMapping("/byInternship/{id}")
    public List<Employee> getByInternship(@PathVariable Long id) {
        List<InternshipParticipant> internshipParticipants = internshipParticipantRepository.findByInternship_id(id);

        List<Employee> employees = new ArrayList<>();
        for (InternshipParticipant i : internshipParticipants) {
            employees.add(i.getEmployee());
        }

        return employees;
    }

    @PostMapping
    public ResponseEntity<Employee> addOne(@RequestBody NewEmployee newEmployee) {
        Employee e = employeeRepository.findByEmail(newEmployee.getEmail());
        if (e != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Employee employee = new Employee();
        employee.setEmail(newEmployee.getEmail());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setCity(newEmployee.getCity());
        employee.setAdministrator(newEmployee.getAdministrator());
        employee.setOffice(newEmployee.getOffice());
        employee = employeeRepository.save(employee);

        AuthCredentials authCredentials = new AuthCredentials();
        authCredentials.setId(employee.getId());
        authCredentials.setEmail(employee.getEmail());
        authCredentials.setPasswordHash(newEmployee.getPasswordHash());
        authCredentialsRepository.save(authCredentials);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
    }
}