package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.Dto.LivraisonDto;
import com.S2t.ConsommiTounsi.entities.Livraison;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/livraison")
public class LivraisonController {
    @Autowired
    LivraisonService livraisonService;

    @PostMapping
    public Livraison createLivraison(@RequestBody LivraisonDto livraisonDto  ) throws RessourcesNotFound {
        return livraisonService.save(livraisonDto);
    }
    @GetMapping
    public List<LivraisonDto> getLivraisons(){
        return livraisonService.getLivraisons();
    }
    @GetMapping(value="/{id}")
    public LivraisonDto getLivraison(@PathVariable("id") Long id) throws RessourcesNotFound {
        return livraisonService.getLivraison(id);

    }
    @GetMapping(value="/Livreurs/find")
    public List<LivraisonDto> findByLivreur(@RequestParam("LivreurId") Long idLivreur) throws RessourcesNotFound {
        return livraisonService.getLivraisonByLivreur(idLivreur);
    }
    @GetMapping(value="/get")
    public LivraisonDto getLivraisonByParam(@RequestParam("livraisonId") Long id) throws RessourcesNotFound {
        return livraisonService.getLivraison(id);
    }

    @DeleteMapping
    public Map<String,Boolean> delete(@RequestParam("id")Long id) throws RessourcesNotFound {
        return livraisonService.deleteLivraison(id);
    }

    @PutMapping("/{id}")
    public Livraison updateLivraison(@PathVariable("id")long id,@RequestBody LivraisonDto livraisonDto)
            throws RessourcesNotFound {
        return livraisonService.update(id,livraisonDto);
    }


}
