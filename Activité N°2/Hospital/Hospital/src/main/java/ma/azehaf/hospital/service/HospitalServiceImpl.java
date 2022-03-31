package ma.azehaf.hospital.service;

import lombok.AllArgsConstructor;
import ma.azehaf.hospital.entities.Consultation;
import ma.azehaf.hospital.entities.Medecin;
import ma.azehaf.hospital.entities.Patient;
import ma.azehaf.hospital.entities.RendezVous;
import ma.azehaf.hospital.repositories.ConsultationRepository;
import ma.azehaf.hospital.repositories.MedecinRepository;
import ma.azehaf.hospital.repositories.PatientRepository;
import ma.azehaf.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
