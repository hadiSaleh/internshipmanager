package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.InternshipAttachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InternshipAttachmentRepository extends CrudRepository<InternshipAttachment, Long> {
    List<InternshipAttachment> findByInternship_id(Long internshipId);
}
