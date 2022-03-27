package ma.azehaf.users_roles.service;

import ma.azehaf.users_roles.Entities.Role;
import ma.azehaf.users_roles.Entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String role);
    void addRoleToUser(String username, String roleName);
}
