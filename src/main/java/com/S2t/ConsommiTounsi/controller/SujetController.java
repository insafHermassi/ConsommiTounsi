package com.S2t.ConsommiTounsi.controller;

import com.S2t.ConsommiTounsi.entities.Sujet;
import com.S2t.ConsommiTounsi.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Sujet")
public class SujetController {
    @Autowired
    SujetService sujetService;
    @PostMapping
    public Sujet saveSujet(@RequestBody Sujet sujet){

        return sujetService.Save(sujet);
    }

    @GetMapping
    public List<Sujet> getSujet() {
        return sujetService.getSujet();
    }

    @GetMapping(value = "/{id}")

    public Sujet getSujet(@PathVariable("id")long id)  {
        return sujetService.getSujet(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteSujet(@RequestParam("id") long id){
        return sujetService.deleteSujet(id);
    }

    @PutMapping
    public Sujet updateSujet(@RequestParam("id") long id, @RequestBody Sujet sujet){
        return  sujetService.updateSujet(id, sujet);
    }
    @GetMapping(value = "/find")
    public  List<Sujet> findByTitle(@RequestParam("title") String title) {
        return sujetService.findByTitle(title);
    }

    @GetMapping(value = "/search")
    public  List<Sujet> searchBycreateDat(@RequestParam("createDat") Date createDat){
        return sujetService.searchBycreateDat(createDat);
    }
   /* @GetMapping(value = "/search/")
    public  List<Sujet> orderedBynumberOfStars(@RequestParam("numberOfStars)") double numberOfStars){
        return sujetService.orderedBynumberOfStars(numberOfStars);
    }*/
}
