package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livreurs")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class LivreurController {

    @Autowired
    LivreurService livreurService;
    @PostMapping
    public Livreur creteLivreur(@Valid @RequestBody Livreur livreur){
        return livreurService.save(livreur);
    }
    @GetMapping
    public List<Livreur> getLivreurs(){
        return livreurService.getLivreurs();
    }
    @GetMapping(value="/{id}")
    public Livreur getLivreur(@PathVariable("id") Long id) throws RessourcesNotFound {
        return livreurService.getLivreur(id);
    }

    @GetMapping(value="/get")
    public Livreur getLivreurByParam(@RequestParam("livreurId") Long id) throws RessourcesNotFound {
        return livreurService.getLivreur(id);
    }

    @DeleteMapping
    public Map<String,Boolean> delete(@RequestParam("id")Long id){
        return livreurService.deleteLivreur(id);
    }

    @PutMapping
    public Livreur updateLivraison(@Valid @RequestParam("id") Long id , @RequestBody Livreur livreur) throws RessourcesNotFound {
        return livreurService.update(id,livreur);
    }
}
