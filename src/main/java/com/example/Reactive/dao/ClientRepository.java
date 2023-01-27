package com.example.Reactive.dao;

import com.example.Reactive.entity.Client;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends R2dbcRepository<Client, Integer> {

    Mono<Client> findById(Integer id);

    Mono<Client> findByName(String name);

    Mono<Client> findBySurName(String surName);

    Mono<Client> findByEmail(String email);
    @Override
    Flux<Client> findAll();
}
