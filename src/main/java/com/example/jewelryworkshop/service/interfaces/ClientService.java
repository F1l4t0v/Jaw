package com.example.jewelryworkshop.service.interfaces;

import com.example.jewelryworkshop.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client getOne(String id);
    Client create(Client client);
    Client update(Client client);
    void delete(String id);
}
