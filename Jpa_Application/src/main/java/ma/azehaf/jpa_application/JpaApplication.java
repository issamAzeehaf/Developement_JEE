package ma.azehaf.jpa_application;

import ma.azehaf.jpa_application.Entities.Patient;
import ma.azehaf.jpa_application.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"issam",new Date(),false,80));
        patientRepository.save(new Patient(null,"youness",new Date(),true,50));
        patientRepository.save(new Patient(null,"wiam",new Date(),false,75));

        for (int i=0;i<100;i++){
            patientRepository.save(new Patient(null,"wiam",new Date(),false,75));
        }
        //Pagination
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(0,5));
        pagePatients.forEach(p->{
            System.out.println("id => "+p.getId()+"\tnom => "+p.getNom()+"\t\tdateN => "+p.getDateNaissance()+"\tmalade => "+p.isMalade()+"\tscore => "+p.getScore());
        });
        //Avoir le total des pages
        System.out.println(pagePatients.getTotalPages());
        //Methode findAll de JpaRepository
        List<Patient> listePatients = patientRepository.findAll();
        listePatients.forEach(p->{
            System.out.println("id => "+p.getId()+"\tnom => "+p.getNom()+"\t\tdateN => "+p.getDateNaissance()+"\tmalade => "+p.isMalade()+"\tscore => "+p.getScore());
        });
        System.out.println("*********************");
        //Methode findBuId de JpaRepository
        Patient patient = patientRepository.findById(3L).orElse(null);
        System.out.println("id => "+patient.getId()+"\tnom => "+patient.getNom()+"\t\tdateN => "+patient.getDateNaissance()+"\tmalade => "+patient.isMalade()+"\tscore => "+patient.getScore());
        patient.setScore(90);
        patientRepository.save(patient);

        //Liste des patient qui sont malade
        List<Patient> ByMalade = patientRepository.findByMalade(true);
        ByMalade.forEach(p->{
            System.out.println("id => "+p.getId()+"\tnom => "+p.getNom()+"\t\tdateN => "+p.getDateNaissance()+"\tmalade => "+p.isMalade()+"\tscore => "+p.getScore());
        });

        //methode delete de JpaRepository
        patientRepository.delete(patient);

    }
}
