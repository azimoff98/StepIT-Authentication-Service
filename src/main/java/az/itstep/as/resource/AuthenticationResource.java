package az.itstep.as.resource;


import az.itstep.as.dto.JwtAuthenticationRequest;
import az.itstep.as.dto.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody JwtAuthenticationRequest request){

        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(){

        return null;
    }


}
