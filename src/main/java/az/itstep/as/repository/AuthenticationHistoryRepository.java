package az.itstep.as.repository;

import az.itstep.as.entities.AuthenticationHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationHistoryRepository extends CrudRepository<AuthenticationHistory, Long> {
}
