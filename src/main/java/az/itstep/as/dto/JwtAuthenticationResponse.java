package az.itstep.as.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtAuthenticationResponse {

    private final String token;
}
