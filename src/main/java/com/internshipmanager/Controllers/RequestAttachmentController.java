package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.RequestAttachment;
import com.internshipmanager.Repositories.RequestAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("requestAttachments")
public class RequestAttachmentController {
    @Autowired
    private RequestAttachmentRepository repository;

    @GetMapping
    public List<RequestAttachment> all() {
        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/{id}")
    public RequestAttachment getOne(@PathVariable Long id) {
        Optional<RequestAttachment> requestAttachment = repository.findById(id);
        return requestAttachment.orElse(null);
    }

    @GetMapping("/byRequest/{requestId}")
    public List<RequestAttachment> getByRequest(@PathVariable Long requestId) {
        List<RequestAttachment> requestAttachments = repository.findByRequest_id(requestId);

        return requestAttachments;
    }

    @PostMapping()
    public RequestAttachment addOne(@RequestBody RequestAttachment requestAttachment) {
        return repository.save(requestAttachment);
    }
}
