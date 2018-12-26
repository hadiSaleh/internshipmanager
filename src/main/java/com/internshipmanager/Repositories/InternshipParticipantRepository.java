package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.InternshipParticipant;
import org.springframework.data.repository.CrudRepository;

public interface InternshipParticipantRepository  extends CrudRepository<InternshipParticipant, Long> {
}
