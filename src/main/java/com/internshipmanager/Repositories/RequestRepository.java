package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findByInternship_idAndEmployee_id(long internshipId, long employeeId);

    List<Request> findByInternship_id(long id);

    List<Request> findByEmployee_id(long id);
}
