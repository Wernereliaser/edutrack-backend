package com.education.track.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String grade;
    private String className;
    private String schoolName;
    private LocalDate enrollmentDate;
    private String role;
    private boolean active;
    private boolean emailVerified;
    private String phoneNumber;
    private String address;
    private Integer totalLeaveDays;
    private Integer remainingLeaveDays;
    @OneToOne(cascade = CascadeType.ALL)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;
}
