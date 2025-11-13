package tn.esprit.tp_foyer_ahmed_brahem.entites;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUniversite;
    private String nomUniversite;
    private String addressUniversite;

//Relation
    @OneToOne
    private Foyer foyer;
}
