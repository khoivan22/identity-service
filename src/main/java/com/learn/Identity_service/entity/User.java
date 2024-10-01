package com.learn.Identity_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
