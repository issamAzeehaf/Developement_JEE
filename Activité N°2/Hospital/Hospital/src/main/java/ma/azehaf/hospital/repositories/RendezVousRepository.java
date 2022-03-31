package ma.azehaf.hospital.repositories;

import ma.azehaf.hospital.entities.Medecin;
import ma.azehaf.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
