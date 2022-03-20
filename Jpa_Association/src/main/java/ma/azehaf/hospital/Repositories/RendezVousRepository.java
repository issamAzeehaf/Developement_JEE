package ma.azehaf.hospital.Repositories;

import ma.azehaf.hospital.Entities.Patient;
import ma.azehaf.hospital.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
