package org.example.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @NotBlank
    private String fullName;

    @NotBlank
    @Pattern(regexp = "\\+\\d(-\\d{3}){2}-\\d{4}", message = "Phone is incorrect")
    private String phoneNumber;

    @Pattern(regexp = "^(.+)@(S+) $.", message = "Email is incorrect")
    @Email(message = "Некорректный email")
    private String email;
}
