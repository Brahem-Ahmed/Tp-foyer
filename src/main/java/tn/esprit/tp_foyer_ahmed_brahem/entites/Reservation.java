package tn.esprit.tp_foyer_ahmed_brahem.entites;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idReservation;
    private Date anneUniversitaire;
    private boolean estValide;

    
    @ManyToMany()
    private List<Etudiant> etudiants;
}