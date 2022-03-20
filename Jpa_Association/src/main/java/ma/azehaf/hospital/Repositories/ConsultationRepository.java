package ma.azehaf.hospital.Repositories;

import ma.azehaf.hospital.Entities.Consultation;
import ma.azehaf.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
