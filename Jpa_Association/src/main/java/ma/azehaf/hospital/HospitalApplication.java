package ma.azehaf.hospital;

import ma.azehaf.hospital.Entities.*;
import ma.azehaf.hospital.Repositories.ConsultationRepository;
import ma.azehaf.hospital.Repositories.MedecinRepository;
import ma.azehaf.hospital.Repositories.PatientRepository;
import ma.azehaf.hospital.Repositories.RendezVousRepository;
import ma.azehaf.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService HospitalService,PatientRepository patientRepository,
                            MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("issam","younes","wiam").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                HospitalService.savePatient(patient);
            });
            Stream.of("Ayman","hanane","yassmin").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecin.setEmail(name+"@gmail.com");
                HospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("issam");

            Medecin medecin = medecinRepository.findByNom("yassmin");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ....");
            HospitalService.saveConsultation(consultation);


        };

    }
}
