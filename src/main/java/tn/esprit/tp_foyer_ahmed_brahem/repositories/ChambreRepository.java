package tn.esprit.tp_foyer_ahmed_brahem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.entites.TypeChambre;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findByBlocCapaciteBlocAndBlocFoyerCapaciteFoyer(long bloc_capaciteBloc, long bloc_foyer_capaciteFoyer);
    List<Chambre> findByNumeroChambreIn(List<Long> idChambre);
    List<Chambre> findByBlocIdBloc(long idBloc);
    List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUniversite);
    List<Chambre> findByTypeChambreAndBlocIdBloc(TypeChambre typeChambre, long idBloc);
    @Query(value = "SELECT c FROM Chambre c WHERE c.bloc.idBloc =:bloc AND c.typeChambre =:typeChambre")
    List<Chambre> retournerLesChambresParTypeEtBloc(TypeChambre typeChambre, long bloc);
    @Query(value = "SELECT c FROM Chambre c " +
            "WHERE c.typeChambre =:typeChambre " +
            "AND c.bloc.foyer.universite.nomUniversite =:nomUniversite " +
            "AND (SELECT COUNT(r) FROM c.reservations r) = 0"
    )
    List<Chambre> retournerLesChambresNonReserveesParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre typeChambre);

    @Query(value = "SELECT c FROM Chambre c, Reservation r " +
            "WHERE (SELECT COUNT(r) FROM c.reservations r) = 0 " +
            "AND r.anneUniversitaire =:date ")
    List<Chambre> retournerLesChambresNonReserveesParAnnee(LocalDate date);

    @Query(value = "SELECT c FROM Chambre c , Reservation r" +
            " WHERE NOT EXISTS (SELECT r FROM c.reservations r ) " +
            "AND r.anneUniversitaire =:date ")
    List<Chambre> retourLesChambresNonReserveesParAnnee(LocalDate date);

}
