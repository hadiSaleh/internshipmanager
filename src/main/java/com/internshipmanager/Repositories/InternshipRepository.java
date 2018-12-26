package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Internship;
import org.springframework.data.repository.CrudRepository;

public interface InternshipRepository  extends CrudRepository<Internship, Long> {
}
