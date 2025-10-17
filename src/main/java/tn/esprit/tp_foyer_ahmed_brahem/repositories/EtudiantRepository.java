package tn.esprit.tp_foyer_ahmed_brahem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
