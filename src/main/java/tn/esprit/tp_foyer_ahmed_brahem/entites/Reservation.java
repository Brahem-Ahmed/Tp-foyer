package tn.esprit.tp_foyer_ahmed_brahem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String idReservation;
    private Date anneUniversitaire;
    private boolean estValide;

    @JsonIgnore
    @ManyToMany()
    private List<Etudiant> etudiants;
}