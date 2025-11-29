package tn.esprit.tp_foyer_ahmed_brahem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Reservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query(value = "SELECT r FROM Chambre c Join c.reservations r " +
            "WHERE r.anneUniversitaire =:anneeUniversite " +
            " AND c.bloc.foyer.universite.nomUniversite =:nomUniversite ")
    List<Reservation> retourneListeReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite);


}
