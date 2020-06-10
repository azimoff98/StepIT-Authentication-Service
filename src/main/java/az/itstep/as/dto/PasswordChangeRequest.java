package az.itstep.as.dto;

import lombok.Data;

@Data
public class PasswordChangeRequest {

    private String oldPassword;
    private String newPassword;
    private String repeatedPassword;

}
