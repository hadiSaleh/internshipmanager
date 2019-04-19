package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.RequestAttachment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestAttachmentRepository extends CrudRepository<RequestAttachment, Long> {
    List<RequestAttachment> findByRequest_id(Long requestId);
}
