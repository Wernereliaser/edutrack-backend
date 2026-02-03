package com.education.track.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LearnerDTO {

    /* ========= Identity ========= */
    private Long id;                    // DB id
    private String keycloakId;           // JWT "sub"
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;

    /* ========= Academic ========= */
    private String grade;                // e.g. "Grade 10"
    private String className;            // e.g. "10A"
    private String studentNumber;
    private String schoolName;
    private LocalDate enrollmentDate;

    /* ========= Authorization ========= */
    private String role;                 // LEARNER, TEACHER, ADMIN

    /* ========= Status ========= */
    private boolean active;
    private boolean emailVerified;

    /* ========= Contact ========= */
    private String phoneNumber;
    private String address;

    /* ========= Audit ========= */
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;

    // getters & setters

}

