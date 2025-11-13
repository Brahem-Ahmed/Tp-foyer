package tn.esprit.tp_foyer_ahmed_brahem.entites;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    //Relation
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
}
