package ma.azehaf.users_roles.repositories;

import ma.azehaf.users_roles.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String role);
}
