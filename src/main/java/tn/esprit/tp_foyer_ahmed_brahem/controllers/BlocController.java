package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BlocController {
    IBlocService blocService;
    @GetMapping("/blocs")
    public List<Bloc> retrieveAllBlocs() {
        return blocService.retrieveAllBlocs();
    }
    @PostMapping("/blocs/add")
    public Bloc addBloc(@RequestBody Bloc f) {
        return blocService.addBloc(f);
    }

    public Bloc updateBloc(Bloc f) {
        return blocService.updateBloc(f);
    }

    public Bloc retrieveBloc(long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    public void removeBloc(long idBloc) {
        blocService.removeBloc(idBloc);
    }



}
