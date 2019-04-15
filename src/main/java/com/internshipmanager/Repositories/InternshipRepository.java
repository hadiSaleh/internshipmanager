package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.Internship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InternshipRepository  extends CrudRepository<Internship, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Internship i SET i.imageCount = :imageCount WHERE i.id = :internshipId")
    void updateImageCountForInternship(@Param("internshipId") long internshipId, @Param("imageCount") int imageCount);
}
