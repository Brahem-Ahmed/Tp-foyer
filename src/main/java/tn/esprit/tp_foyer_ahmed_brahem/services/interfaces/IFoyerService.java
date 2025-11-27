package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;

import tn.esprit.tp_foyer_ahmed_brahem.entites.Foyer;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Universite;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
