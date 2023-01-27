package com.example.Reactive.service;

import com.example.Reactive.dao.ClientRepository;
import com.example.Reactive.dto.ClientDTO;
import com.example.Reactive.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    Mono<ClientDTO> getClientById(Integer id) {
        return clientRepository.findById(id)
                .map(ClientMapper::convertEntityToDto)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<ClientDTO> getClientByName(String name) {
        return clientRepository.findByName(name)
                .map(ClientMapper::convertEntityToDto)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<ClientDTO> getClientBySurName(String surname) {
        return clientRepository.findBySurName(surname)
                .map(ClientMapper::convertEntityToDto)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<ClientDTO> getClientByEmail(String email) {
        return clientRepository.findByEmail(email)
                .map(ClientMapper::convertEntityToDto)
                .subscribeOn(Schedulers.parallel());
    }

    Flux<ClientDTO> getAllClient() {
        return clientRepository.findAll()
                .map(ClientMapper::convertEntityToDto)
                .subscribeOn(Schedulers.parallel());
    }
}
