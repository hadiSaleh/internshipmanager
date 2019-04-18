package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Goal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoalRepository extends CrudRepository<Goal, Long> {
    List<Goal> findByInternship_idAndEmployee_id(long internshipId, long employeeId);

    List<Goal> findByInternship_id(long id);

    List<Goal> findByEmployee_id(long id);

    @Modifying
    @Transactional
    @Query("UPDATE Goal i SET i.attachmentCount = :attachmentCount WHERE i.id = :goalId")
    void updateAttachmentCountForGoal(@Param("goalId") long goalId, @Param("attachmentCount") int attachmentCount);
}
