package com.example.Reactive.mapper;

import com.example.Reactive.dto.ClientDTO;
import com.example.Reactive.entity.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {

    public static ClientDTO convertEntityToDto(Client client) {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(client, ClientDTO.class);
    }
}
