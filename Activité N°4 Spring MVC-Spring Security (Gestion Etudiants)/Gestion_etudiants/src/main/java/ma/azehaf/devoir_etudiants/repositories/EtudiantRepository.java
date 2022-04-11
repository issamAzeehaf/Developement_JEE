package ma.azehaf.devoir_etudiants.repositories;

import ma.azehaf.devoir_etudiants.Entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Page<Etudiant> findByNomContains(String nom, Pageable pageable);
}
