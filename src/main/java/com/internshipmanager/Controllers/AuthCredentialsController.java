package com.internshipmanager.Controllers;


import com.internshipmanager.Entities.AuthCredentials;
import com.internshipmanager.Entities.Employee;
import com.internshipmanager.Repositories.AuthCredentialsRepository;
import com.internshipmanager.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
public class AuthCredentialsController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthCredentialsRepository authCredentialsRepository;

    @PostMapping
    public Employee auth(@RequestBody AuthCredentials authCredentials) {
        AuthCredentials auth = authCredentialsRepository.findByEmail(authCredentials.getEmail());
        if (auth == null) {
            return null;
        }

        if (auth.getPasswordHash().equals(authCredentials.getPasswordHash())) {
            return employeeRepository.findByEmail(auth.getEmail());
        }

        return null;
    }
}
