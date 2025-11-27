package tn.esprit.tp_foyer_ahmed_brahem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocCapaciteBlocAndBlocFoyerCapaciteFoyer(long bloc_capaciteBloc, long bloc_foyer_capaciteFoyer);
    List<Chambre> findByNumeroChambreIn(List<Long> idChambre);
    List<Chambre> findByBlocIdBloc(long idBloc);
}
