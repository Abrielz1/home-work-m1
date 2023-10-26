package org.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private String phoneNumber;

    @Email(message = "Некорректный email")
    private String email;
}
