package tn.esprit.tp_foyer_ahmed_brahem.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    private String idReservation;
    private Date anneUniversitaire;
    private boolean estValide;

    
    @ManyToMany()
    private List<Etudiant> etudiants;
}