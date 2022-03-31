package ma.azehaf.hospital.repositories;

import ma.azehaf.hospital.entities.Consultation;
import ma.azehaf.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
