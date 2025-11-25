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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idChambre;
    private  long numeroChambre;
    @Enumerated(EnumType.STRING)
    private  TypeChambre typeChambre;
    @ManyToOne
    private Bloc bloc;
    @JsonIgnore
    @OneToMany
    private List<Reservation> reservations;

}
