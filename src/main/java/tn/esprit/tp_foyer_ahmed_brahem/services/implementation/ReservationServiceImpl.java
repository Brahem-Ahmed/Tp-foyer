package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Reservation;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ReservationRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IReservationService;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;

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
}
