package az.itstep.as.service;

import az.itstep.ts.model.JwtTokenParameter;
import az.itstep.ts.util.JwtTokenGenerator;
import az.itstep.ts.util.JwtTokenUtil;
import az.itstep.ts.util.JwtTokenValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Date;

@Service
@Slf4j
public class TokenService {

    private final JwtTokenGenerator tokenGenerator;
    private final JwtTokenValidator tokenValidator;
    private final JwtTokenUtil tokenUtil;

    public TokenService(@Value("${default.jwt.secret}") String secret, @Value("${default.jwt.expiration}") Long expiration) {
        JwtTokenParameter jwtTokenParameter = new JwtTokenParameter(secret, expiration);
        this.tokenGenerator = new JwtTokenGenerator(jwtTokenParameter);
        this.tokenValidator = new JwtTokenValidator(jwtTokenParameter);
        this.tokenUtil = new JwtTokenUtil(secret);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return tokenValidator.validaToken(token, userDetails);
    }

    public String generateToken(UserDetails userDetails) {
        return tokenGenerator.generateToken(userDetails);
    }

    public String refreshToken(String token) {
        return tokenGenerator.refreshToken(token);
    }

    public String getUsernameFromToken(String token) {
        return tokenUtil.getUsernameFromToken(token);
    }

    public Date getExpirationDateFromToken(String token) {
        return tokenUtil.getExpirationDateFromToken(token);
    }

}
