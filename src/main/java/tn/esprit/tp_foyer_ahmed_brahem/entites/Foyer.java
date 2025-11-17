package tn.esprit.tp_foyer_ahmed_brahem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    //Relation
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    @JsonIgnore
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
