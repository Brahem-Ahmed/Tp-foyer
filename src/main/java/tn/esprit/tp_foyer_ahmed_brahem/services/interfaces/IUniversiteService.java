package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;

import tn.esprit.tp_foyer_ahmed_brahem.entites.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite f);
    Universite updateUniversite (Universite f);
    Universite retrieveUniversite (long idUniversite);
    void removeUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    Universite afficherUniversiteParCinEtudiant(long cin);
    Universite desaffecterFoyerAUniversite(long idUniversite);
}