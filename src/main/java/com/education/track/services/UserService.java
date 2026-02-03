package com.education.track.services;

import com.education.track.entities.User;
import com.education.track.repositories.UserRepository;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getOrCreateCurrentUser(Jwt jwt) {

        String keycloakId = jwt.getSubject(); // token "sub"
        String username = jwt.getClaimAsString("preferred_username");
        String email = jwt.getClaimAsString("email");
        String firstName = jwt.getClaimAsString("given_name");
        String lastName = jwt.getClaimAsString("family_name");
        String defaultRole = "LEARNER";

        return repository.findByKeycloakId(keycloakId)
                .orElseGet(() -> {
                    User user = new User();
                    user.setKeycloakId(keycloakId);
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setRole(defaultRole);
                    return repository.save(user);
                });
    }

    public void deleteCurrentUser(Jwt jwt) {
        String keycloakId = jwt.getSubject();
        repository.findByKeycloakId(keycloakId)
                .ifPresent(repository::delete);
    }
}

