package com.learn.Identity_service.dto.request;

import com.learn.Identity_service.constant.AttributeConstant;
import com.learn.Identity_service.constant.ErrorCodeConstant;
import com.learn.Identity_service.validator.Constraint.DateConstraint;
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
public class UserCreationRequest {
    @Size(min = 4, message = ErrorCodeConstant.USERNAME_INVALID)
    String username;
    String password;
    String firstname;
    String lastname;
    @DateConstraint(min = 18, message = ErrorCodeConstant.INVALID_DATE, paramMessageNames = {AttributeConstant.MIN_ATTRIBUTE})
    LocalDate dob;
    Set<String> roles;
}
