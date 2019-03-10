package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Nullable
    Employee findByEmail(String email);
}
