package ma.azehaf.stuuddents.security.repositories;

import ma.azehaf.stuuddents.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
