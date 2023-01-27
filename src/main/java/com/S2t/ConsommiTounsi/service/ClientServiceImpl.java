package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Client;
import com.S2t.ConsommiTounsi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;


    @Override
    public Client Save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Map<String, Boolean> deleteClient(long id) {
        clientRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public Client updateClient(long id, Client client) {
        Client old = getClient(id);
        old.setFirstname(client.getFirstname());
        old.setLastname(client.getLastname());
        old.setAddress(client.getAddress());
        old.setPhone(client.getPhone());
        old.setEmail(client.getEmail());
        return clientRepository.save(old);
    }

    @Override
    public List<Client> findByFirstnameOrLastname(String firstaname, String lastname) {
        return clientRepository.findByFirstnameOrLastname(firstaname, lastname);
    }
}