package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.Client;
import com.S2t.ConsommiTounsi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/client")
public class ClientController extends BasicController{
    @Autowired
    ClientService clientService;
    @PostMapping
    public Client saveClient(@RequestBody Client client) {

        return clientService.save(client);
    }

    @GetMapping
    public List<Client> getClient() {

        return clientService.getClient();
    }

    @GetMapping(value = "/{id}")

    public Client getClient (@PathVariable("id") long id) {
        return clientService.getClient(id);
    }

    @DeleteMapping
    public Map<String, Boolean> deleteClient(@RequestParam("id") long id) {
        return clientService.deleteClient(id);
    }


    @PutMapping
    public Client updateClient(@RequestParam("id") long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

}
