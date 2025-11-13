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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long idChambre;
    private  long numeroChambre;
    @Enumerated
    private  TypeChambre typeChambre;

    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private List<Reservation> reservations;

}
