package az.itstep.as.mapper;

import az.itstep.as.dto.UserSignUpRequest;
import az.itstep.as.entities.ApplicationUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SignUpRequestMapper extends BaseMapper<UserSignUpRequest, ApplicationUser> {

    @Override
    ApplicationUser toEntity(UserSignUpRequest dto);

    @Override
    UserSignUpRequest toDTO(ApplicationUser entity);
}
