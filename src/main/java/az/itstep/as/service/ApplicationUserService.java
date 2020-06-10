package az.itstep.as.service;

import az.itstep.as.dto.UserSignUpRequest;
import az.itstep.as.entities.ApplicationUser;
import az.itstep.as.exception.SingUpRequestException;
import az.itstep.as.mapper.SignUpRequestMapper;
import az.itstep.as.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserService {

    private final ApplicationUserRepository repository;
    private final SignUpRequestMapper signUpRequestMapper;

    public void save(UserSignUpRequest request){
        if(! request.getPassword().equals(request.getRepeatPassword()))
            throw new SingUpRequestException("Passwords are not matching");

        ApplicationUser applicationUser = signUpRequestMapper.toEntity(request);
        applicationUser.setIsActive(true);
        applicationUser.setCreationDate(LocalDateTime.now());
        applicationUser.setLastPasswordChangeDate(LocalDateTime.now());

        repository.save(applicationUser);
    }

    public List<ApplicationUser> findAll(){
        return (List<ApplicationUser>) repository.findAll();
    }
}
