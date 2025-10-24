package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.EtudiantRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IEtudiantService;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository  etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
