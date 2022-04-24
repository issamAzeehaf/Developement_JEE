package ma.azehaf.stuuddents;

import ma.azehaf.stuuddents.entities.Gender;
import ma.azehaf.stuuddents.entities.Student;
import ma.azehaf.stuuddents.repositories.StudentRepository;
import ma.azehaf.stuuddents.security.CustomLogoutSuccessHandler;
import ma.azehaf.stuuddents.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.Date;

@SpringBootApplication
public class StuuddentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuuddentsApplication.class, args);
    }

    @Bean
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    //@Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            studentRepository.save(new Student(null,"Azehaf","issam","issam.azf@gmail.com",new Date(), Gender.MASCULIN,false));
            studentRepository.save(new Student(null,"elamri","wiam","wiam.el@gmail.com",new Date(), Gender.FEMININ,true));
            studentRepository.save(new Student(null,"mbarako","younes","younes.mb@gmail.com",new Date(), Gender.MASCULIN,true));
            studentRepository.save(new Student(null,"syah","fatima","fatima.syah@gmail.com",new Date(), Gender.FEMININ,false));

            studentRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("issam", "1234", "1234");
            securityService.saveNewUser("chinwi", "1234", "1234");
            securityService.saveNewUser("younes", "1234", "1234");

            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("issam", "USER");
            securityService.addRoleToUser("issam", "ADMIN");
            securityService.addRoleToUser("chinwi", "USER");
            securityService.addRoleToUser("younes", "USER");


        };
    }

}
