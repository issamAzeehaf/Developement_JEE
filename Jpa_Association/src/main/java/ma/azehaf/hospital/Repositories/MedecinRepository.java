package ma.azehaf.hospital.Repositories;

import ma.azehaf.hospital.Entities.Medecin;
import ma.azehaf.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
