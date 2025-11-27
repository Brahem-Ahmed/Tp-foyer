package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Foyer;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IFoyerService;

import java.util.List;
@Tag(name= "Espace des Foyers ")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FoyerController {
    IFoyerService foyerService;
    @Operation(description = "Retourne la liste des espaces des blocs")
    @GetMapping("/foyers")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }
    @Operation(description = "Ajouter Foyer")
    @PostMapping("/foyers/add")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }
    @Operation(description = "Modifier Foyer")
    @PutMapping("/foyers/update")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return foyerService.updateFoyer(f);
    }
    @Operation(description = "Retourner Foyer par ID")
    @GetMapping("/foyers/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable  long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }
    @Operation(description = "Supprimer Foyer ")
    @DeleteMapping("/foyers/delete/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }

    @PostMapping("/foyers/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
