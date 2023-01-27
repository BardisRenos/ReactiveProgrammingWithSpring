package com.example.Reactive.controller;

import com.example.Reactive.dto.ClientDTO;
import com.example.Reactive.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "api/v1/client/")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/all")
    public Flux<ClientDTO> getAllClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/{email}")
    public Mono<ClientDTO> getClientByEmail(String email) {
        return clientService.getClientWithEmail(email);
    }

    @PostMapping("/insert")
    public Mono<ClientDTO> saveClient(@RequestBody Mono<ClientDTO> clientDTOMono) {
        return clientService.saveClient(clientDTOMono);
    }
}
