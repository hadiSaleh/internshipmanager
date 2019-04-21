package com.internshipmanager.Controllers;


import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Internship;
import com.internshipmanager.Entities.InternshipParticipant;
import com.internshipmanager.Repositories.InternshipParticipantRepository;
import com.internshipmanager.Repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("internships")
public class InternshipController {
    @Autowired
    private InternshipRepository internshipRepository;

    @Autowired
    private InternshipParticipantRepository internshipParticipantRepository;

    @GetMapping
    public List<Internship> all() {
        return Lists.newArrayList(internshipRepository.findAll());
    }

    @GetMapping("/{id}")
    public Internship getOne(@PathVariable Long id) {
        Optional<Internship> internship = internshipRepository.findById(id);
        return internship.orElse(null);
    }

    @PostMapping()
    public Internship addOne(@RequestBody Internship newInternship) {
        return internshipRepository.save(newInternship);
    }

    @GetMapping("/{id}/updateImageCount/{imageCount}")
    public void updateInternshipImageCount(@PathVariable Long id, @PathVariable Integer imageCount) {
        internshipRepository.updateImageCountForInternship(id, imageCount);
    }

    @GetMapping("/byEmployee/{id}")
    public List<Internship> getByEmployee(@PathVariable Long id) {
        List<InternshipParticipant> internshipParticipants = internshipParticipantRepository.findByEmployee_id(id);

        List<Internship> internships = new ArrayList<>();
        for (InternshipParticipant i : internshipParticipants) {
            internships.add(i.getInternship());
        }

        return internships;
    }

    @PostMapping("complete")
    public Internship completeInternship(@RequestBody Internship updatedInternship) {
        Internship internship = internshipRepository.findById(updatedInternship.getId()).get();
        internship.setActive(false);
        return internshipRepository.save(internship);
    }
}
