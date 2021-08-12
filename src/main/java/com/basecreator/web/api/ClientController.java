package com.basecreator.web.api;


import com.basecreator.domain.model.client.Client;
import com.basecreator.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/get/all")
    public List<Client> getAllClients(){
        return clientService.getAllClient();
    }

    @PostMapping("/add")
    public Client addClient(Client client){
        return clientService.save(client);
    }
}
