package com.internshipmanager.Repositories;

import com.internshipmanager.Entities.AuthCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface AuthCredentialsRepository extends CrudRepository<AuthCredentials, Long> {
    @Nullable
    AuthCredentials findByEmail(String email);
}
