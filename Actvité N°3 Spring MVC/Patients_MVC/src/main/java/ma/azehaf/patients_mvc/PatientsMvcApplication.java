package ma.azehaf.patients_mvc;

import ma.azehaf.patients_mvc.entities.Patient;
import ma.azehaf.patients_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Azehaf",new Date(),false,18));
            patientRepository.save(new Patient(null,"mbarako",new Date(),true,12));
            patientRepository.save(new Patient(null,"elamri",new Date(),true,20));
            patientRepository.save(new Patient(null,"syah",new Date(),false,14));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });




        };
    }

}
