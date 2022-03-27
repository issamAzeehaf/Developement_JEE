package ma.azehaf.users_roles.repositories;

import ma.azehaf.users_roles.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUserName(String userName);
}
