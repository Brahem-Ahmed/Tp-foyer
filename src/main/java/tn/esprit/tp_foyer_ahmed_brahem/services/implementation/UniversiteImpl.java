package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Foyer;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Universite;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.FoyerRepository;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.UniversiteRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IUniversiteService;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteImpl implements IUniversiteService {
    private final FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite f) {
        return universiteRepository.save(f);
    }

    @Override
    public Universite updateUniversite(Universite f) {
        return universiteRepository.save(f);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = foyerRepository.findById(idFoyer).orElse(null);
        Universite u = universiteRepository.findByNomUniversite(nomUniversite);
        if (f != null && u != null) {
            u.setFoyer(f);
            return universiteRepository.save(u);
        }
        else
            return null;
    }
}
