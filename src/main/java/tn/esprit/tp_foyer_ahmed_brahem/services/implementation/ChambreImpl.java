package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ChambreRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IChambreService;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreImpl implements IChambreService {
    ChambreRepository chambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre f) {
        return chambreRepository.save(f);
    }

    @Override
    public Chambre updateChambre(Chambre f) {
        return chambreRepository.save(f);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(long idChambre) {
            chambreRepository.deleteById(idChambre);
    }
}
