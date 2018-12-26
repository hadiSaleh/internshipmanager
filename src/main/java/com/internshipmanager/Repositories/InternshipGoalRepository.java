package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.InternshipGoal;
import org.springframework.data.repository.CrudRepository;

public interface InternshipGoalRepository  extends CrudRepository<InternshipGoal, Long> {
}
