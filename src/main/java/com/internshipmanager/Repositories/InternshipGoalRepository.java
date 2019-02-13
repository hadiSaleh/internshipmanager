package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Goal;
import org.springframework.data.repository.CrudRepository;

public interface InternshipGoalRepository  extends CrudRepository<Goal, Long> {
}
