package tn.esprit.tp_foyer_ahmed_brahem.services.interfaces;


import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc (Bloc f);
    Bloc updateBloc (Bloc f);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);
}
