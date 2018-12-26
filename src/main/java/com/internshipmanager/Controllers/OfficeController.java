package com.internshipmanager.Controllers;


import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Office;
import com.internshipmanager.Repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("offices")
public class OfficeController {
    @Autowired
    private OfficeRepository repository;

    @GetMapping
    public List<Office> all() {
        return Lists.newArrayList(repository.findAll());
    }

    @GetMapping("/{id}")
    public Office getOne(@PathVariable Long id){
        Optional<Office> employee = repository.findById(id);
        return employee.orElse(null);
    }

    @PostMapping()
    public Office addOne(@RequestBody Office newOffice) {
        return repository.save(newOffice);
    }
}
