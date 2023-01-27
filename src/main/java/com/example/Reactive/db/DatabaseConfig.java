package com.example.Reactive.db;

import com.example.Reactive.dao.ClientRepository;
import com.example.Reactive.entity.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = ClientRepository.class)
@Configuration
public class DatabaseConfig {

    @Bean
    public CommandLineRunner initDB(ClientRepository clientRepository){
        return (args) -> {
            List<Client> users = new ArrayList<>(Arrays.asList(new Client(1, "Renos", "Bardis", "renos@gmail.com"),
                    new Client(2, "Nikos", "Papas", "nikos@gmail.com"),
                    new Client(3, "Aggelos", "MPalallis", "aggelos@gmail.com"),
                    new Client(4, "Vaggelis", "Papagkikas", "vaggelis@gmail.com")));
            clientRepository.saveAll(users);
        };
    }

}
