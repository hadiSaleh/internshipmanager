package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository  extends CrudRepository<ChatMessage, Long> {
}
