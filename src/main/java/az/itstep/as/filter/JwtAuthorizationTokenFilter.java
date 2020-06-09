package az.itstep.as.filter;

import az.itstep.as.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Qualifier("jwtUserDetailService")
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    @Value("${default.jwt.header}")
    private String header;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        log.info("processing authentication for: {}", request.getRequestURL());

        String requestHeader = request.getHeader(this.header);
        log.info("Request header is: {}", requestHeader);

        String tokenPrefix = "Bearer ";
        String username = null;
        String authToken = null;

        if(Objects.nonNull(requestHeader) && requestHeader.startsWith(tokenPrefix)){
            authToken = requestHeader.substring(tokenPrefix.length());
            try{
                username = tokenService.getUsernameFromToken(authToken);
            }catch (ExpiredJwtException e){
                log.error("Jwt is expired");
            }
        }else{
            log.warn("could not find bearer string, will ignore header");
        }

        log.info("Checking authentication for user: {}", username);

        if(Objects.nonNull(username) && SecurityContextHolder.getContext().getAuthentication() == null){
            log.info("Security context was null so authorizing user");

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(tokenService.validateToken(authToken, userDetails)){
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                log.info("authorized user {}, setting security context.", username);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}
