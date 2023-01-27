package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.Dto.CommandDto;
import com.S2t.ConsommiTounsi.entities.Command;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/commands")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommandController extends  BasicController {
    @Autowired
    CommandService commandService;


    @GetMapping(value = "/welcome")
    public String welcome () {
        return "Welcome , i'am a robot . I will help you to manage commandes.";
    }
    @PostMapping
    public Command createCommand(@RequestParam("IdClient") long idClient, @RequestParam("tva") Double tva){


        return commandService.save(idClient,tva);
    }

    @GetMapping
    public List<Command> getCommand(){

        return commandService.getCommands();
    }
    @GetMapping(value ="/{id}")
    public Command getCommand(@PathVariable("id")long id){
        return commandService.getCommand(id);
    }
    @GetMapping(value = "/get")
    public Command getCommandByParam(@RequestParam("commandeId")long id){

        return commandService.getCommand(id);
    }
    @DeleteMapping
    public Map<String,Boolean> deleteCommand(@RequestParam("id") long id){

        return commandService.deleteCommand(id);
    }
    @PutMapping
    public Command updateCommand(@PathVariable("id")long id, @RequestBody CommandDto commandDto) throws RessourcesNotFound {
        return commandService.updateCommand(id,commandDto);
    }
    @GetMapping(value = "/find")
    public List<Command> getBynumComm(@RequestParam("NumComm")String numComm ){
        return commandService.searchCommandByNumComm(numComm);
    }
    @GetMapping(value ="/search")
    public List<Command> search(@RequestParam("DateComm") Date dateComm){
        return commandService.searchCommandBydateComm( dateComm);
    }
}