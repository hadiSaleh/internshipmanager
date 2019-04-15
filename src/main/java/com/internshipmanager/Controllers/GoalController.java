package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Goal;
import com.internshipmanager.Repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("goals")
public class GoalController {
    @Autowired
    private GoalRepository goalRepository;

    @GetMapping
    public List<Goal> all() {
        return Lists.newArrayList(goalRepository.findAll());
    }

    @GetMapping("/{id}")
    public Goal getOne(@PathVariable Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        return goal.orElse(null);
    }

    @GetMapping("/byInternship/{internshipId}/byEmployee/{employeeId}")
    public List<Goal> getByInternshipAndEmployee(@PathVariable Long internshipId, @PathVariable Long employeeId) {
        List<Goal> goals = goalRepository.findByInternship_idAndEmployee_id(internshipId, employeeId);

        return goals;
    }

    @PostMapping()
    public Goal addOne(@RequestBody Goal newGoal) {
        return goalRepository.save(newGoal);
    }
}
