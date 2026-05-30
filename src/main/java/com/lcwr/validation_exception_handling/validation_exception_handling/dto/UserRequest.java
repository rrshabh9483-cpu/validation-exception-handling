package com.lcwr.validation_exception_handling.validation_exception_handling.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    private int userid;
    @NotNull(message = "user name should not be null")
    private String name;

    private String email;
   @Pattern(regexp = "^[6-9]\\d{9}$",message = "invalid mobile number")
    private String mobile;
    private String gender;
    @Max(60)
    @Min(1)
    private int age;
    private String nationality;
}
