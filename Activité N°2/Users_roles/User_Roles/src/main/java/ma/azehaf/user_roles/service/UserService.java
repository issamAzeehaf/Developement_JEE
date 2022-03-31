package ma.azehaf.user_roles.service;

import ma.azehaf.user_roles.Entities.Role;
import ma.azehaf.user_roles.Entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName, String password);

}
