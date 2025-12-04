package tn.esprit.tp_foyer_ahmed_brahem.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.entites.TypeChambre;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.BlocRepository;
import tn.esprit.tp_foyer_ahmed_brahem.repositories.ChambreRepository;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IChambreService;

import java.time.LocalDate;
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

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);

    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {

        return chambreRepository.findByTypeChambreAndBlocIdBloc(typeC,idBloc);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) {
        return chambreRepository.retournerLesChambresParTypeEtBloc(typeC,idBloc);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.retournerLesChambresNonReserveesParNomUniversiteEtTypeChambre(nomUniversite,type);
    }
    @Scheduled(cron = "*/10 * * * * *")
    @Override
    public void afficherChambresNonReserveesPendantCetteAnnees() {
        System.out.println("Les chambres non reservees pendant l'années:" + LocalDate.now().getYear()+ " sont :");
        for(Chambre chambre : chambreRepository.retournerLesChambresNonReserveesParAnnee(LocalDate.ofEpochDay(LocalDate.now().getYear())))
        {
            System.out.println(chambre);
        }
     //   System.out.println(chambreRepository.retournerLesChambresNonReserveesParAnnee().toString());
    }

    @Scheduled(fixedRate = 10000)
    @Override
    public void retournerLesChambresNonReserveesParAnnee() {
       List<Chambre> listechambre = chambreRepository.retourLesChambresNonReserveesParAnnee(LocalDate.ofEpochDay(LocalDate.now().getYear()));
        System.out.println("Les chambres non reservees de cette annee : "
                + LocalDate.now().getYear() + " sont : " );
       for (Chambre chambre : listechambre ) {
            System.out.println(chambre);
        }

    }


}




