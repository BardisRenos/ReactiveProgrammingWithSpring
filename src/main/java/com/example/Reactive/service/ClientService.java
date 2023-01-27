package com.example.Reactive.service;

import com.example.Reactive.dao.ClientRepository;
import com.example.Reactive.dto.ClientDTO;
import com.example.Reactive.entity.Client;
import com.example.Reactive.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
//@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(@Qualifier("clientRepository") ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    Mono<ClientDTO> getClientById(Integer id) {
        return clientRepository.findById(id)
                .map(ClientMapper::convertEntityToDto);
    }

    Mono<ClientDTO> getClientByName(String name) {
        return clientRepository.findByName(name)
                .map(ClientMapper::convertEntityToDto);
    }

    Mono<ClientDTO> getClientBySurName(String surname) {
        return clientRepository.findBySurName(surname)
                .map(ClientMapper::convertEntityToDto);
    }

    Mono<ClientDTO> getClientByEmail(String email) {
        return clientRepository.findByEmail(email)
                .map(ClientMapper::convertEntityToDto);
    }

    public Flux<ClientDTO> getAllClient() {
        return clientRepository.findAll()
                .map(ClientMapper::convertEntityToDto);
    }

    public Mono<ClientDTO> getClientWithEmail(String email) {
        return clientRepository.findByEmail(email).map(ClientMapper::convertEntityToDto);
    }

    public Mono<ClientDTO> saveClient(Mono<ClientDTO> clientDTOMono) {
        return clientDTOMono.map(ClientMapper::convertDtoToClient)
                .flatMap(clientRepository::insert)
                .map(ClientMapper::convertEntityToDto);
    }
}
