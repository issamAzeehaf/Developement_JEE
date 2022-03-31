package ma.azehaf.hospital;

import ma.azehaf.hospital.entities.*;
import ma.azehaf.hospital.repositories.ConsultationRepository;
import ma.azehaf.hospital.repositories.MedecinRepository;
import ma.azehaf.hospital.repositories.PatientRepository;
import ma.azehaf.hospital.repositories.RendezVousRepository;
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
    CommandLineRunner start(IHospitalService iHospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository){
        return args -> {
            Stream.of("issam","younes","wiam").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                iHospitalService.savePatient(patient);
            });
            Stream.of("ayman","hanane","yasmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecin.setEmail(name+"@gmail.com");
                iHospitalService.saveMedecin(medecin);
            });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("issam");

            Medecin medecin = medecinRepository.findByNom("ayman");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setAnnule(StatusRDV.DONE);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient1);
            iHospitalService.saveRDV(rendezVous);

            Consultation consultation = new Consultation();
            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ....");
            iHospitalService.saveConsultation(consultation);




        };
    }


}
