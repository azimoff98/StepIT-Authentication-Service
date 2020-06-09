package az.itstep.as.resource;


import az.itstep.as.dto.JwtAuthenticationRequest;
import az.itstep.as.dto.JwtAuthenticationResponse;
import az.itstep.as.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationResource {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody JwtAuthenticationRequest request){
        log.info("Authentication request for user: {}", request.getUsername());
        JwtAuthenticationResponse response = authenticationService.createAuthentication(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(){

        return null;
    }


}
