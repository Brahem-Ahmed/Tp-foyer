package tn.esprit.tp_foyer_ahmed_brahem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Chambre;
import tn.esprit.tp_foyer_ahmed_brahem.entites.Etudiant;
import tn.esprit.tp_foyer_ahmed_brahem.services.interfaces.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Tag(name= "Espace Etudiant")

public class EtudiantController {
    IEtudiantService etudiantService;

    @Operation(description = "Retourne la liste des espaces des blocs")
    @GetMapping("/etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }
    @Operation(description = "Ajouter Etudiant")
    @PostMapping("/etudiants/add")
    public Etudiant addEtudiant(@RequestBody Etudiant f) {
        return etudiantService.addEtudiant(f);
    }
    @Operation(description = "Modifier Etudiant")
    @PutMapping("/etudiants/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant f) {
        return etudiantService.updateEtudiant(f);
    }
    @Operation(description = "Retourner Etudiant par ID")
    @GetMapping("/etudiants/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable  long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }
    @Operation(description = "Supprimer Etudiant par ID")
    @DeleteMapping("/etudiants/delete/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
