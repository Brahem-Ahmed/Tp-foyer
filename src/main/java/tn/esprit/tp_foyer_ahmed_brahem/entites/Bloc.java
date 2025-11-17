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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    @JsonIgnore
    @ManyToOne
    public Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "bloc")
    public List<Chambre> chambres;
}
