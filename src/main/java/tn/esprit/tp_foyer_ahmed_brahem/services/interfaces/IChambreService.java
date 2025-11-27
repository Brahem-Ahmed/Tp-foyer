package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;

import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre (Chambre f);
    Chambre updateChambre (Chambre f);
    Chambre retrieveChambre (long idChambre);
    void removeChambre (long idChambre);
    List<Chambre> afficheChambreParCapaciteBlocEtCapaciteFoyer(long cap_bloc, long cap_foy);
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
