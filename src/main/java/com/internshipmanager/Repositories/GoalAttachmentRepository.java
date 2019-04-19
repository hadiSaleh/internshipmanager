package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.GoalAttachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoalAttachmentRepository extends CrudRepository<GoalAttachment, Long> {
    List<GoalAttachment> findByGoal_id(Long goalId);
}
