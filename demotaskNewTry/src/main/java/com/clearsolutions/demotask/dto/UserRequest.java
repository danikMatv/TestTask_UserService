package com.clearsolutions.demotask.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Data
@Builder
public class UserRequest {

    public static final String EMAIL_REGEX =
        "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

    public static final String PHONE_NUMBER_REGEX =
            "^(\\+\\d{1,3})?[- .]?(\\(\\d{1,3}\\)|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";


    @Email(regexp = EMAIL_REGEX,flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email has to be in a valid format!")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]+",
            message = "Must start with a capital letter")
    private String lastName;

    @Pattern(regexp = PHONE_NUMBER_REGEX,
            message = "Phone number has to be in a valid format!")
    private String phoneNumber;

    private String address;

    @Past(message = "Birth date must bu in the past")
    private LocalDate date;

    @Transient
    private Integer age;
}
