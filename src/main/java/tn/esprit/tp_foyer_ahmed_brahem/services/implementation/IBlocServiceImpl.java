package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.BlocRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IBlocService;

import java.util.List;

@Service
@AllArgsConstructor
public class IBlocServiceImpl implements IBlocService {
    BlocRepository blocRepository; // >> Instance by constructor

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc f) {
        return blocRepository.save(f);
    }

    @Override
    public Bloc updateBloc(Bloc f) {
        return blocRepository.save(f);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
