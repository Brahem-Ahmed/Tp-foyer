package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;

import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant f);
    Etudiant updateEtudiant (Etudiant f);
    Etudiant retrieveEtudiant (long idEtudiant);
    void removeEtudiant (long idEtudiant);
}

