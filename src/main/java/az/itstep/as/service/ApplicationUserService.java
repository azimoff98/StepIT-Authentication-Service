package az.itstep.as.service;

import az.itstep.as.entities.ApplicationUser;
import az.itstep.as.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserService {

    private final ApplicationUserRepository repository;

    public List<ApplicationUser> findAll(){
        return (List<ApplicationUser>) repository.findAll();
    }
}
