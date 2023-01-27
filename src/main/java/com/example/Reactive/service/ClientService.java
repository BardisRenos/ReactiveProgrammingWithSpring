package com.example.Reactive.service;

import com.example.Reactive.dao.ClientRepository;
import com.example.Reactive.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    Mono<Client> getClientById(Integer id) {
        return clientRepository.findById(id)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<Client> getClientByName(String name) {
        return clientRepository.findByName(name)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<Client> getClientBySurName(String surname) {
        return clientRepository.findBySurName(surname)
                .subscribeOn(Schedulers.parallel());
    }

    Mono<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email)
                .subscribeOn(Schedulers.parallel());
    }

    Flux<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
