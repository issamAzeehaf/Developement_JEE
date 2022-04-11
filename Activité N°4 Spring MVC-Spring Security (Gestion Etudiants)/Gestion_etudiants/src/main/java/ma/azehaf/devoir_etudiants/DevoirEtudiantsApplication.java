package ma.azehaf.devoir_etudiants;

import ma.azehaf.devoir_etudiants.Entities.Etudiant;
import ma.azehaf.devoir_etudiants.Entities.Genre;
import ma.azehaf.devoir_etudiants.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DevoirEtudiantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevoirEtudiantsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(EtudiantRepository etudiantRepository) {
        return args -> {
            etudiantRepository.save(new Etudiant(null, "Azehaf", "issam", "issam.azf@gmail.com", new Date(), Genre.MASCULIN, false));
            etudiantRepository.save(new Etudiant(null, "elamri", "wiam", "wiam.el@gmail.com", new Date(), Genre.FEMININ, true));
            etudiantRepository.save(new Etudiant(null, "mbarako", "younes", "younes.mb@gmail.com", new Date(), Genre.MASCULIN, true));
            etudiantRepository.save(new Etudiant(null, "syah", "fatima", "fatima.syah@gmail.com", new Date(), Genre.FEMININ, false));

            etudiantRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });


        };
    }

}
