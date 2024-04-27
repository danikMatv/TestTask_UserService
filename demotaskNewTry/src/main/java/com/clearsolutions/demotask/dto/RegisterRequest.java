package com.clearsolutions.demotask.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static com.clearsolutions.demotask.dto.UserRequest.EMAIL_REGEX;
import static com.clearsolutions.demotask.dto.UserRequest.PHONE_NUMBER_REGEX;

@Data
@Builder
public class RegisterRequest {

    @NotBlank(message = "Email cannot be empty")
    @Email(regexp = EMAIL_REGEX,flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email has to be in a valid format!")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String firstName;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String lastName;

    @Pattern(regexp = PHONE_NUMBER_REGEX,
            message = "Phone number has to be in a valid format!")
    private String phoneNumber;

    private String address;

    @Past(message = "Birth date must bu in the past")
    @NotBlank(message = "Name cannot be empty")
    private LocalDate date;

    @Transient
    private Integer age;

}
