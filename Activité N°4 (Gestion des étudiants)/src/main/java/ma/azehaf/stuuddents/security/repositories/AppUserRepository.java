package ma.azehaf.stuuddents.security.repositories;

import ma.azehaf.stuuddents.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
