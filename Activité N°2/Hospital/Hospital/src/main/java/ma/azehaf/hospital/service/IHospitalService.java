package ma.azehaf.hospital.service;

import ma.azehaf.hospital.entities.Consultation;
import ma.azehaf.hospital.entities.Medecin;
import ma.azehaf.hospital.entities.Patient;
import ma.azehaf.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
