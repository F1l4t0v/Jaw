package com.example.jewelryworkshop.service.impl;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Client;
import com.example.jewelryworkshop.model.enums.Regular;
import com.example.jewelryworkshop.repository.ClientRepository;
import com.example.jewelryworkshop.service.interfaces.ClientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository repository;

    //@PostConstruct
    void init(){
        repository.save(new Client("Іванко", "Іван", "Іванович", Regular.REGULAR));
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        String id = client.getId();
        Client client1 = this.getOne(id);
        client.setCreatedAt(client1.getCreatedAt());
        client.setUpdatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
