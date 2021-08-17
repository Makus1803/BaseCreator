package com.basecreator.domain.service;

import com.basecreator.domain.model.client.Client;
import com.basecreator.domain.model.client.ClientRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public List<Client> getFromCsv() throws IOException {

        return new CsvToBeanBuilder<Client>(new FileReader("C:\\Java\\BaseCreator\\src\\main\\resources\\baza-adsy.csv"))
                .withType(Client.class)
                .build()
                .parse();
    }

    public List<Client> saveClientsFromCsv(List<Client> clientsFromCsv) {
        clientsFromCsv.parallelStream().forEach(client -> clientRepository.save(client));

        return clientRepository.findAll();
    }

}
