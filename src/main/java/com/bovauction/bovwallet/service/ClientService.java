package com.bovauction.bovwallet.service;

import com.bovauction.bovwallet.dto.ClientDto;
import com.bovauction.bovwallet.exception.AppException;
import com.bovauction.bovwallet.model.Client;
import com.bovauction.bovwallet.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private void checkEmailAndCpf(final ClientDto clientData) {
        if (clientRepository.existsUserByCpf(clientData.getCpf())) {
            throw new AppException("Cpf already in use", HttpStatus.CONFLICT);
        }

        if (clientRepository.existsUserByEmail(clientData.getEmail())) {
            throw new AppException("Email already in use", HttpStatus.CONFLICT);
        }
    }

    public Client createClient(final ClientDto clientData) {

        checkEmailAndCpf(clientData);

        final Client createClient = new Client(clientData.getName(), clientData.getCpf(), clientData.getEmail(), clientData.getType());

        return clientRepository.save(createClient);
    }

    public List<Client> readClients() { return clientRepository.findAll(); }

    public Client retrieveClient(final long id) {
        return clientRepository.findById(id).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
    }


    public Client updateUser(final ClientDto clientData, final long id) {

        checkEmailAndCpf(clientData);

        final Client userToBeUpdated = clientRepository.findById(id).orElseThrow(() -> new AppException("Client not found", HttpStatus.NOT_FOUND));

        userToBeUpdated.setName(clientData.getName());
        userToBeUpdated.setCpf(clientData.getCpf());
        userToBeUpdated.setEmail(clientData.getEmail());
        userToBeUpdated.setType(clientData.getType());

        return clientRepository.save(userToBeUpdated);
    }

    public void deleteUser(final long id) {
        final Client userToBeDeleted = clientRepository.findById(id).orElseThrow(() -> new AppException("Client not found", HttpStatus.NOT_FOUND));

        clientRepository.delete(userToBeDeleted);
    }
}
