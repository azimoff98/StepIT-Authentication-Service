package az.itstep.as.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String address;
    private String username;
    private String password;
    private Boolean isActive;
    private LocalDateTime creationDate;
    private LocalDateTime lastPasswordChangeDate;

}
