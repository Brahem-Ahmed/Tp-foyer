package tn.esprit.tp_foyer_ahmed_brahem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private int cin;
    private String ecole;
    private Date dateNaissance;
    @JsonIgnore
    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations;
}
