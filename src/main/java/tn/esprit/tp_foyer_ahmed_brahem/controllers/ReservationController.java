package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Reservation;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IReservationService;

import java.util.List;
@Tag(name= "Espaces des Reservations")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ReservationController {
    IReservationService reservationService;
    @Operation(description = "Retourne la liste des espaces des blocs")
    @GetMapping("/reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }
    @Operation(description = "Ajouter Reservation")
    @PostMapping("/reservations/add")
    public Reservation addReservation(@RequestBody Reservation f) {
        return reservationService.addReservation(f);
    }
    @Operation(description = "Modifier Reservation")
    @PutMapping("/reservations/update")
    public Reservation updateReservation(@RequestBody Reservation f) {
        return reservationService.updateReservation(f);
    }
    @Operation(description = "Retourner Reservation par ID")
    @GetMapping("/reservations/{idReservation}")
    public Reservation retrieveReservation(@PathVariable  long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
    @Operation(description = "Supprimer Reservation ")
    @DeleteMapping("/reservations/delete/{idReservation}")
    public void removeReservation(@PathVariable long idReservation) {
        reservationService.removeReservation(idReservation);
    }
}
