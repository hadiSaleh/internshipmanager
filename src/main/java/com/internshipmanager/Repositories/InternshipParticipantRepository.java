package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.InternshipParticipant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InternshipParticipantRepository  extends CrudRepository<InternshipParticipant, Long> {
    List<InternshipParticipant> findByEmployee_id(long id);

}
