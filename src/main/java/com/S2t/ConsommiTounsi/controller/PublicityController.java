package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.CanalPub;
import com.S2t.ConsommiTounsi.entities.Population;
import com.S2t.ConsommiTounsi.entities.Publicity;
import com.S2t.ConsommiTounsi.service.PublicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publicities")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PublicityController extends BasicController {
    @Autowired
    PublicityService publicityService;

    @PostMapping
    public Publicity savePublicity(@RequestBody Publicity publicity) {

        return publicityService.Save(publicity);
    }

    @GetMapping
    public List<Publicity> getPublicity() {
        return publicityService.getPublicity();
    }

    @GetMapping(value = "/{id}")

    public Publicity getPublicity(@PathVariable("id") long id) {
        return publicityService.getPublicity(id);
    }

    @DeleteMapping
    public Map<String, Boolean> deletePublicity(@RequestParam("id") long id) {
        return publicityService.deletePublicity(id);
    }


    @PutMapping
    public Publicity updatePublicity(@RequestParam("id") long id, @RequestBody Publicity publicity) {
        return publicityService.updatePublicity(id, publicity);
    }

    @GetMapping(value = "/find")
    public List<Publicity> getByPopulation(@RequestParam("population") Population population) {
        return publicityService.findByPopulation(population);
    }

    /* @GetMapping(value = "/search")
     public List<Publicity> getByCanalPub(@RequestParam("CanalPub") CanalPub canalPub) {
         return publicityService.searchByCanalPub(canalPub);
     }*/
    @GetMapping("/search")
    public List<Publicity> getByTypePub(@RequestParam("typePub") String typePub) {
        return publicityService.findBytypePub(typePub);
    }

    @GetMapping("/advancedSearch")

    public List<Publicity> getByCanalPubANDnbrOfViews (@RequestParam("CanalPub") CanalPub canalPub,
                                                       @RequestParam("nbrOfViews") double nbrOfViews) {
        return publicityService.advancedSearach(canalPub, nbrOfViews);
    }
}
