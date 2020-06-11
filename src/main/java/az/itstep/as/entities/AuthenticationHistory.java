package az.itstep.as.entities;

import az.itstep.as.model.AuthenticationOperationEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class AuthenticationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Enumerated(EnumType.STRING)
    private AuthenticationOperationEnum authenticationOperationEnum;
    private LocalDateTime operationTime;
}
