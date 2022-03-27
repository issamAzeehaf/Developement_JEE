package ma.azehaf.users_roles;

import ma.azehaf.users_roles.Entities.Role;
import ma.azehaf.users_roles.Entities.User;
import ma.azehaf.users_roles.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersRolesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersRolesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User user = new User();
            user.setUserName("user1");
            user.setPassword("123456");
            userService.addNewUser(user);

            User user2 = new User();
            user.setUserName("admin");
            user.setPassword("123456");
            userService.addNewUser(user2);

            Stream.of("student", "user", "admin").forEach(r->{
                Role role = new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });

            userService.addRoleToUser("user1","student");
            userService.addRoleToUser("user1","user");
            userService.addRoleToUser("admin","user");
            userService.addRoleToUser("admin","admin");



        };
    }
}
