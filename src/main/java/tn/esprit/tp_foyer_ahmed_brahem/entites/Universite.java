package tn.esprit.tp_foyer_ahmed_brahem.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String addressUniversite;

//Relation
    @JsonIgnore
    @OneToOne
    private Foyer foyer;
}
