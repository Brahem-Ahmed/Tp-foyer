package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IBlocService;

import java.util.List;
@Tag(name= "Espaces des BLocs")

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BlocController {
    IBlocService blocService;
    @Operation(description = "Retourne la liste des espaces des blocs")
    @GetMapping("/blocs")
    public List<Bloc> retrieveAllBlocs() {
        return blocService.retrieveAllBlocs();
    }
    @Operation(description = "Ajouter Bloc")
    @PostMapping("/blocs/add")
    public Bloc addBloc(@RequestBody Bloc f) {
        return blocService.addBloc(f);
    }
    @Operation(description = "Modifier Bloc")
    @PutMapping("/blocs/update")
    public Bloc updateBloc(@RequestBody Bloc f) {
        return blocService.updateBloc(f);
    }
    @Operation(description = "Retourner Bloc par ID")
    @GetMapping("/blocs/{idBloc}")
    public Bloc retrieveBloc(@PathVariable  long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }
    @Operation(description = "Supprimer Bloc ")
    @DeleteMapping("/blocs/delete/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        blocService.removeBloc(idBloc);
    }



}
