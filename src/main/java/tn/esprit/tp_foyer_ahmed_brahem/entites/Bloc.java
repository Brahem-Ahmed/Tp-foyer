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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    @ManyToOne
    public Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    public List<Chambre> chambres;
}
