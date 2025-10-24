package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;

import tn.esprit.tp_foyer_ahmed_brahem.entites.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation (Reservation f);
    Reservation updateReservation (Reservation f);
    Reservation retrieveReservation (long idReservation);
    void removeReservation (long idReservation);
}