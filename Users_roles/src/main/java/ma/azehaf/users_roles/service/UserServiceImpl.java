package ma.azehaf.users_roles.service;

import lombok.AllArgsConstructor;
import ma.azehaf.users_roles.Entities.Role;
import ma.azehaf.users_roles.Entities.User;
import ma.azehaf.users_roles.repositories.RoleRepository;
import ma.azehaf.users_roles.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String role) {
        return roleRepository.findByRoleName(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);
    }
}
