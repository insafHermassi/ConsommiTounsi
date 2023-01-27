package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.Facture;
import com.S2t.ConsommiTounsi.entities.TypeFact;
import com.S2t.ConsommiTounsi.service.FactureService;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/factures")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class FactureController extends BasicController {

    FactureService factureService;

    @PostMapping
    public Facture saveFacture(@RequestBody Facture facture) {

        return factureService.Save(facture);
    }

    @GetMapping
    public List<Facture> getFacture() {
        return factureService.getFacture();
    }

    @GetMapping(value = "/{id}")

    public Facture getFacture(@PathVariable("id") long id) {
        return factureService.getFacture(id);
    }

    @DeleteMapping
    public Map<String, Boolean> deleteFacture(@RequestParam("id") long id) {
        return factureService.deleteFacture(id);
    }

    @PutMapping
    public Facture updateFacture(@RequestParam("id") long id, @RequestBody Facture facture) {
        return factureService.updateFcture(id, facture);
    }

    @GetMapping(value = "/find")
    public List<Facture> getBytypeFact(@RequestParam("typeFact") TypeFact typeFact) {
        return factureService.findBytypeFact(typeFact);
    }

    @GetMapping(value = "/search")
    public List<Facture> getBydate(@RequestParam("date") Date date) {
        return factureService.findBydate(date);
    }
}
