package ma.azehaf.hospital.repositories;

import ma.azehaf.hospital.entities.Medecin;
import ma.azehaf.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
