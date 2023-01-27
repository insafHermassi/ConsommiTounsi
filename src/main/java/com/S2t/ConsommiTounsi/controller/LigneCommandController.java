package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.Dto.LigneCommandDto;
import com.S2t.ConsommiTounsi.entities.LigneCommand;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.LigneCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/ligneCommands")
public class LigneCommandController extends BasicController {
    @Autowired
    LigneCommandService ligneCommandService;
    @PostMapping
    public LigneCommand createligneCommand(@RequestBody LigneCommandDto ligneCommandDto) throws RessourcesNotFound {

        return ligneCommandService.save(ligneCommandDto);
    }
    @GetMapping
    public List<LigneCommand> getLigneCommand(){

        return ligneCommandService.getLigneCommnands();
    }
    @GetMapping("/{id}")
    public LigneCommand getLigneCommand(@PathVariable("id")long id){

        return ligneCommandService.getLigneCommand(id);
    }
    @GetMapping(value = "/get")
    public LigneCommand getLigneCommandByParam(@RequestParam("ligneCommandId")long id){

        return ligneCommandService.getLigneCommand(id);
    }
    @DeleteMapping
    public Map<String,Boolean> deleteLigneCommand(@RequestParam("id") long id){

        return ligneCommandService.deleteLigneCommand(id);
    }
    @PutMapping
    public LigneCommand updateLigneCommand(@RequestBody LigneCommandDto ligneCommandDto) {
        return ligneCommandService.updateLigneCommand(ligneCommandDto);
    }
    @GetMapping(value = "/findDate")
    public List<LigneCommand> getByDate(@RequestParam("Date") Date date ){
        return ligneCommandService.searchByDate(date);
    }
    @GetMapping(value ="/searchC")
    public List<LigneCommand> searchByCommand(@RequestParam("command-id") Long id){
        return ligneCommandService.searchByCommand(id);
    }
    @GetMapping(value ="/searchP")
    public List<LigneCommand> searchByProduct(@RequestParam("product-id") Long id){
        return ligneCommandService.searchByProduct(id);
    }
}


