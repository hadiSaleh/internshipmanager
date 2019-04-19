package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.GoalAttachment;
import com.internshipmanager.Repositories.GoalAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("goalAttachments")
public class GoalAttachmentController {
    @Autowired
    private GoalAttachmentRepository repository;

    @GetMapping
    public List<GoalAttachment> all() {
        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/{id}")
    public GoalAttachment getOne(@PathVariable Long id) {
        Optional<GoalAttachment> goalAttachment = repository.findById(id);
        return goalAttachment.orElse(null);
    }

    @GetMapping("/byGoal/{goalId}")
    public List<GoalAttachment> getByGoal(@PathVariable Long goalId) {
        List<GoalAttachment> goalAttachments = repository.findByGoal_id(goalId);

        return goalAttachments;
    }

    @PostMapping()
    public GoalAttachment addOne(@RequestBody GoalAttachment goalAttachment) {
        return repository.save(goalAttachment);
    }
}
