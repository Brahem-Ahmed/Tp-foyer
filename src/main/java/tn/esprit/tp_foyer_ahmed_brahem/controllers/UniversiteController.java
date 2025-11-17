package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Universite;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IUniversiteService;

import java.util.List;
@Tag(name= "Espace des Universites")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UniversiteController {
    IUniversiteService  universiteService;
    @Operation(description = "Retourne la liste des espaces des Universites")
    @GetMapping("/universities")
    public List<Universite> retrieveAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }
    @Operation(description = "Ajouter Universite")
    @PostMapping("/universities/add")
    public Universite addUniversite(@RequestBody Universite f) {
        return universiteService.addUniversite(f);
    }
    @Operation(description = "Modifier Universite")
    @PutMapping("/universities/update")
    public Universite updateUniversite(@RequestBody Universite f) {
        return universiteService.updateUniversite(f);
    }
    @Operation(description = "Supprimer Universire par ID")
    @GetMapping("/universities/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable  long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
    @Operation(description = "Supprimer Universite ")
    @DeleteMapping("/universities/delete/{idUniversite}")
    public void removeUniversite(@PathVariable long idUniversite) {
        universiteService.removeUniversite(idUniversite);
    }
    @Operation(description = "Affectation Foyer A Universite (Universite class mere (we don't make affectations at child level wher emaapped by is))")
    @PutMapping("/universites/ajouterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @GetMapping("/universites/afficheUniversiteParCinEtudiant/{cin}")
    public Universite afficherUniversiteParCinEtudiant(@PathVariable long cin) {
        return universiteService.afficherUniversiteParCinEtudiant(cin);
    }
}
