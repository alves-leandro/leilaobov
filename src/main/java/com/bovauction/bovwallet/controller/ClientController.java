package com.bovauction.bovwallet.controller;

import com.bovauction.bovwallet.dto.ClientDto;
import com.bovauction.bovwallet.model.Client;
import com.bovauction.bovwallet.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody final ClientDto clientData) {
        final Client createClient = clientService.createClient((clientData));

        return new ResponseEntity<>(createClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> readClients() {
        final List<Client> allClients = clientService.readClients();

        return new ResponseEntity<>(allClients, HttpStatus.OK);
    }

        @GetMapping("/{id}")
    public ResponseEntity<Client> retrieveUser(@PathVariable String id) {
        final Client user = clientService.retrieveClient(Long.parseLong(id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateUser(@Valid @RequestBody final ClientDto userData, @PathVariable String id) {
        final Client updatedUser = clientService.updateUser(userData, Long.parseLong(id));

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        clientService.deleteUser(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
