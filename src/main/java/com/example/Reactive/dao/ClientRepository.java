package com.example.Reactive.dao;

import com.example.Reactive.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Qualifier("clientRepository")
public interface ClientRepository extends ReactiveMongoRepository<Client, Integer> {

    Mono<Client> findById(Integer id);

    Mono<Client> findByName(String name);

    Mono<Client> findBySurName(String surName);

    Mono<Client> findByEmail(String email);
    @Override
    Flux<Client> findAll();
}
