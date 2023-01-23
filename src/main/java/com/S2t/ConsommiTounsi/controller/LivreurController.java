package com.S2t.ConsommiTounsi.controller;

import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {
    @Autowired
    LivreurService livreurService;
    @PostMapping
    public Livreur saveLivreur(@RequestBody Livreur livreur){

        return livreurService.Save(livreur);
    }

    @GetMapping
    public List<Livreur> getLivreur() {
        return livreurService.getLivreur();
    }

    @GetMapping(value = "/{id}")

    public Livreur getLivreur(@PathVariable("id")long id)  {
        return livreurService.getLivreur(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteLivreur(@RequestParam("id") long id){
        return livreurService.deleteLivreur(id);
    }

    @PutMapping
    public Livreur updateLivreur(@RequestParam("id") long id, @RequestBody Livreur livreur){
        return  livreurService.updateLivreur(id, livreur);
    }

    @GetMapping(value = "/get")
    public  List<Livreur> getByFirstnameOrLastname(@RequestParam("firstnameOrlastname") String firstname, String lastname) {
        return livreurService.findByFirstnameOrlastname(firstname, lastname);
    }

    @GetMapping(value = "/search")
    public  List<Livreur> getByisAvailable(@RequestParam("isAvailable") boolean isAvailable){
        return livreurService.searchByisAvailable(isAvailable);
    }

    @GetMapping(value = "/find")
    public  List<Livreur> getBynbrLivraison(@RequestParam("nbrLivraison") double nbrLivraison){
        return livreurService.searchBynbrLivraison(nbrLivraison);
    }
    @GetMapping(value = "/locate")
    public  List<Livreur> getBycity(@RequestParam("city") String city){
        return livreurService.findBycity(city);
    }

}
