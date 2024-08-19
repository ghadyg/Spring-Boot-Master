package com.spring_boot.person;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.spring_boot.validation.CustomValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPersonRequest(@CustomValidation(message = "Name must not be empty") String name ,
                               @Min(value = 18,message = "Age must be greater than 17") int age,
                               @NotNull(message = "Gender cannot be null") Gender gender,
                               @Email String email){}
