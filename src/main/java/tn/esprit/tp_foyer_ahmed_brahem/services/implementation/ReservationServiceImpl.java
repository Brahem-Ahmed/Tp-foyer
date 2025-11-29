package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Reservation;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ChambreRepository;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.EtudiantRepository;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ReservationRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IReservationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation f) {
        return reservationRepository.save(f);
    }

    @Override
    public Reservation updateReservation(Reservation f) {
        return reservationRepository.save(f);
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepository.findById(String.valueOf(idReservation)).orElse(null);
    }

    @Override
    public void removeReservation(long idReservation) {
        reservationRepository.deleteById(String.valueOf(idReservation));

    }
    @Transactional
    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        String numReservation = chambre.getNumeroChambre()+chambre.getBloc().getNomBloc()
                + LocalDate.now().getYear();
        Reservation r = Reservation.builder()
                .idReservation(numReservation)
                .anneUniversitaire(LocalDate.ofEpochDay(LocalDate.now().getYear()))
                .estValide(true)
                .etudiants(new ArrayList<>())
                .build();
        reservationRepository.save(r);
        chambre.getReservations().add(r);
        r.getEtudiants().add(etudiant);

        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite) {
        return reservationRepository.retourneListeReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite,nomUniversite);
    }


}
