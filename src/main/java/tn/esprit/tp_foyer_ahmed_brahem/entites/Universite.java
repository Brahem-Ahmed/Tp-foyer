package tn.esprit.tp_foyer_ahmed_brahem.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Universite {
    @Id
    private long idUniversite;
    private String nomUniversite;
    private String addressUniversite;

//Relation
    @OneToOne
    private Foyer foyer;
}
