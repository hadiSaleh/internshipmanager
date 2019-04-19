package com.internshipmanager.Controllers;

import com.google.common.collect.Lists;
import com.internshipmanager.Entities.Request;
import com.internshipmanager.Repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("requests")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping
    public List<Request> all() {
        return Lists.newArrayList(requestRepository.findAll());
    }

    @GetMapping("/{id}")
    public Request getOne(@PathVariable Long id) {
        Optional<Request> requestOptional = requestRepository.findById(id);
        return requestOptional.orElse(null);
    }

    @GetMapping("/byInternship/{internshipId}/byEmployee/{employeeId}")
    public List<Request> getByInternshipAndEmployee(@PathVariable Long internshipId, @PathVariable Long employeeId) {
        List<Request> requests = requestRepository.findByInternship_idAndEmployee_id(internshipId, employeeId);

        return requests;
    }

    @PostMapping("complete")
    public Request completeRequest(@RequestBody Request updatedRequest) {
        Request request = requestRepository.findById(updatedRequest.getId()).get();
        request.setCompleted(true);
        return requestRepository.save(request);
    }

    @PostMapping()
    public Request addOne(@RequestBody Request newRequest) {
        return requestRepository.save(newRequest);
    }
}