package az.itstep.as.service;

import az.itstep.as.dto.JwtAuthenticationRequest;
import az.itstep.as.dto.JwtAuthenticationResponse;
import az.itstep.as.exception.AuthenticationException;
import az.itstep.as.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    @Qualifier("jwtUserDetailService")
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final ApplicationUserRepository applicationUserRepository;

    public JwtAuthenticationResponse createAuthentication(JwtAuthenticationRequest request){
        log.info("Authentication request for user: {}", request.getUsername());

        authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        return null;
    }

    private void authenticate(String username, String password){
        if(Objects.isNull(username) || Objects.isNull(password))
            throw new AuthenticationException("Username or password cannot be null");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }



}
