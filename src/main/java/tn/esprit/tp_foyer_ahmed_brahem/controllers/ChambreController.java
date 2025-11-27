package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Bloc;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IChambreService;

import java.util.List;
@Tag(name= "Chambre Section")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ChambreController {
    IChambreService chambreService;
    @Operation(description = "Retourne la liste des chambres")
    @GetMapping("/chambres")
    public List<Chambre> retrieveAllChambres() {
        return chambreService.retrieveAllChambres();
    }
    @Operation(description = "Ajouter Chambre")
    @PostMapping("/chambres/add")
    public Chambre addChambre(@RequestBody Chambre f) {
        return chambreService.addChambre(f);
    }
    @Operation(description = "Modifier Chambre")
    @PutMapping("/chambres/update")
    public Chambre updateChambre(@RequestBody Chambre f) {
        return chambreService.updateChambre(f);
    }
    @Operation(description = "Retourner Chambre par ID")
    @GetMapping("/chambres/{idChambre}")
    public Chambre retrieveChambre(@PathVariable  long idChambre) {
        return chambreService.retrieveChambre(idChambre);
    }
    @Operation(description = "Supprimer Chambre par ID")
    @DeleteMapping("/chambres/delete/{idChambre}")
    public void removeChambre(@PathVariable long idChambre) {
        chambreService.removeChambre(idChambre);
    }
    @GetMapping("/chambres/afficheChambreParCapaciteBlocEtCapaciteFoyer/{cap_bloc}/{cap_foy}")
    public List<Chambre> afficheChambreParCapaciteBlocEtCapaciteFoyer(@PathVariable long cap_bloc,@PathVariable long cap_foy) {
        return chambreService.afficheChambreParCapaciteBlocEtCapaciteFoyer(cap_bloc, cap_foy);
    }
    @PutMapping("/chambres/affecterChambresABloc/{numChambre}/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return chambreService.affecterChambresABloc(numChambre, idBloc);
    }

}
