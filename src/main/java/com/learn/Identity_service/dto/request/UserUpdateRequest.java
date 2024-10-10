package com.learn.Identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String id;
    @Size(min = 4, message = "USERNAME_INVALID")
    String password;
    String firstname;
    String lastname;
    LocalDate dob;
    Set<String> roles;
}
