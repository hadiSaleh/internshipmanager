package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal, Long> {
}
