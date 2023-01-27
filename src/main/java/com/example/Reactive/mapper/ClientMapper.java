package com.example.Reactive.mapper;

import com.example.Reactive.dto.ClientDTO;
import com.example.Reactive.entity.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {

    public static ClientDTO convertEntityToDto(Client client) {
        return new ModelMapper().map(client, ClientDTO.class);
    }

    public static Client convertDtoToClient(ClientDTO clientDTO) {
        return new ModelMapper().map(clientDTO, Client.class);
    }
}
