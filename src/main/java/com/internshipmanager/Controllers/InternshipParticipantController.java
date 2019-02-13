package com.internshipmanager.Controllers;


import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Internship;
import com.internshipmanager.Entities.InternshipParticipant;
import com.internshipmanager.Repositories.InternshipParticipantRepository;
import com.internshipmanager.Repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("internshipParticipants")
public class InternshipParticipantController {
    @Autowired
    private InternshipParticipantRepository internshipParticipantRepository;

    @GetMapping
    public List<InternshipParticipant> all() {
        return Lists.newArrayList(internshipParticipantRepository.findAll());
    }

    @GetMapping("/{id}")
    public InternshipParticipant getOne(@PathVariable Long id){
        Optional<InternshipParticipant> internshipParticipant = internshipParticipantRepository.findById(id);
        return internshipParticipant.orElse(null);
    }

    @PostMapping()
    public InternshipParticipant addOne(@RequestBody InternshipParticipant newInternshipParticipant) {
        return internshipParticipantRepository.save(newInternshipParticipant);
    }
}
