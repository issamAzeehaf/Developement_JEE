package ma.azehaf.hospital.service;

import ma.azehaf.hospital.Entities.Consultation;
import ma.azehaf.hospital.Entities.Medecin;
import ma.azehaf.hospital.Entities.Patient;
import ma.azehaf.hospital.Entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
