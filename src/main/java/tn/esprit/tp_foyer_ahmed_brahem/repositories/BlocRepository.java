package tn.esprit.tp_foyer_ahmed_brahem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByFoyerNomFoyerAndFoyerUniversiteNomUniversite(String nomFoyer, String Nom_Universite);
}
