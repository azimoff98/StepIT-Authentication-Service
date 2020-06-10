package az.itstep.as.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserSignUpRequest {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String surname;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    @Min(13)
    @Max(100)
    private Integer age;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 6)
    private String repeatPassword;

}
