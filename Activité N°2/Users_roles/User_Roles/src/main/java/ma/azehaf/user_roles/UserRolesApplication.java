package ma.azehaf.user_roles;

import ma.azehaf.user_roles.Entities.Role;
import ma.azehaf.user_roles.Entities.User;
import ma.azehaf.user_roles.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserRolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRolesApplication.class, args);
	}
	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			User user = new User();
			user.setUserName("user1");
			user.setPassword("123456");
			userService.addNewUser(user);

			User user2 = new User();
			user2.setUserName("admin");
			user2.setPassword("123456");
			userService.addNewUser(user2);

			Stream.of("STUDENT","USER","ADMIN").forEach(r->{
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);
			});

			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","USER");
			userService.addRoleToUser("admin","ADMIN");

			try{
				User userr = userService.authenticate("user1","123456");
				System.out.println(userr.getUserId());
				System.out.println(userr.getUserName());
				userr.getRoles().forEach(r->{
					System.out.println("Roles : "+r.toString());
				});
			}catch (Exception e){
				e.printStackTrace();
			}


		};
	}

}
