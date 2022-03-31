package ma.azehaf.user_roles.service;

import lombok.AllArgsConstructor;
import ma.azehaf.user_roles.Entities.Role;
import ma.azehaf.user_roles.Entities.User;
import ma.azehaf.user_roles.Repositories.RoleRepository;
import ma.azehaf.user_roles.Repositories.UserRepository;
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
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepository.save(user);

    }

    @Override
    public User authenticate(String userName, String password) {
        User user = findUserByUserName(userName);
        if(user==null){
            throw new RuntimeException("Bad Credentials");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }
}
