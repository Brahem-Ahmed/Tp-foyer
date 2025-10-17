package tn.esprit.tp_foyer_ahmed_brahem.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    @ManyToOne
    public Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    public List<Chambre> chambres;
}
