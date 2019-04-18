package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.InternshipAttachment;
import com.internshipmanager.Repositories.InternshipAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("internshipAttachments")
public class InternshipAttachmentController {
    @Autowired
    private InternshipAttachmentRepository repository;

    @GetMapping
    public List<InternshipAttachment> all() {
        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/{id}")
    public InternshipAttachment getOne(@PathVariable Long id) {
        Optional<InternshipAttachment> internshipAttachment = repository.findById(id);
        return internshipAttachment.orElse(null);
    }

    @GetMapping("/byInternship/{internshipId}")
    public List<InternshipAttachment> getByInternship(@PathVariable Long internshipId) {
        List<InternshipAttachment> internshipAttachments = repository.findByInternship_id(internshipId);

        return internshipAttachments;
    }

    @PostMapping()
    public InternshipAttachment addOne(@RequestBody InternshipAttachment internshipAttachment) {
        return repository.save(internshipAttachment);
    }
}
