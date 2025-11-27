package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.BlocRepository;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ChambreRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IChambreService;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreImpl implements IChambreService {
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;

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

    @Override
    public List<Chambre> afficheChambreParCapaciteBlocEtCapaciteFoyer(long cap_bloc, long cap_foy) {
        return chambreRepository.findByBlocCapaciteBlocAndBlocFoyerCapaciteFoyer(cap_bloc, cap_foy);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }






}




