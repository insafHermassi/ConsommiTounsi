package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.Client;

import java.util.List;
import java.util.Map;

public interface ClientService {
    public Client Save(Client client);

    public Client getClient(long id);

    public List<Client> getClient();

    Client save(Client client);

    public Map<String, Boolean> deleteClient(long id);

    public Client updateClient(long id, Client client);

    public List<Client> findByFirstnameOrLastname(String firstaname, String lastname);
}
