package com.education.track.controllers;

import com.education.track.entities.User;
import com.education.track.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * Get or create current user
     */
    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        return userService.getOrCreateCurrentUser(jwt);
    }

    /**
     * Explicitly create/update current user (idempotent)
     */
    @PostMapping("/me")
    public User updateCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        return userService.getOrCreateCurrentUser(jwt);
    }

    /**
     * Delete current user (DB only, NOT Keycloak)
     */
    @DeleteMapping("/me")
    public void delete(@AuthenticationPrincipal Jwt jwt) {
        userService.deleteCurrentUser(jwt);
    }
}
