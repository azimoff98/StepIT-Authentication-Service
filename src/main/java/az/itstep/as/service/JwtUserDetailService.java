package az.itstep.as.service;

import az.itstep.as.model.JwtUser;
import az.itstep.as.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("jwtUserDetailService")
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final ApplicationUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(JwtUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user with username: "+username+" not found"));

    }
}
