package az.itstep.as.resource;

import az.itstep.as.entities.ApplicationUser;
import az.itstep.as.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class ApplicationUserResource {

    private final ApplicationUserService applicationUserService;

    @GetMapping
    public ResponseEntity<List<ApplicationUser>> findAll(){
        log.info("Rest request for all users");

        List<ApplicationUser> response = applicationUserService.findAll();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
