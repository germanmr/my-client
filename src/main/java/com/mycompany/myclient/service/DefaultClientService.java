package com.mycompany.myclient.service;

import com.mycompany.myclient.dto.ClientDto;
import com.mycompany.myclient.exceptions.NoClientFoundException;
import com.mycompany.myclient.exceptions.NoClientsFoundException;
import com.mycompany.myclient.model.Client;
import com.mycompany.myclient.repository.ClientJpaRepository;
import com.mycompany.myclient.repository.ClientRepository;
import com.mycompany.myclient.service.function.Client2ClientDto;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Service
public class DefaultClientService implements ClientService {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientRepository clientRepository;
    private final Client2ClientDto client2ClientDto;
    private final Set<ClientDto> clientDtos;


    @Inject
    public DefaultClientService(
            @Nonnull ClientRepository clientRepository,
            @Nonnull ClientJpaRepository clientJpaRepository,
            @Nonnull Client2ClientDto client2ClientDto) {
        requireNonNull(clientRepository);
        requireNonNull(clientJpaRepository);
        requireNonNull(client2ClientDto);
        this.clientRepository = clientRepository;
        this.clientJpaRepository = clientJpaRepository;
        this.client2ClientDto = client2ClientDto;

        Set<ClientDto> clientDtos = new HashSet<>();
        clientDtos.add(new ClientDto(1, "German"));
        this.clientDtos = clientDtos;

    }

    @Override
    public ClientDto getById(@Nonnull Long clientId) {
        requireNonNull(clientId);

        Client client = clientRepository.findById(clientId);

        ClientDto clientDto = client2ClientDto.apply(client);

        return clientDto;

    }

    @Override
    public ClientDto getByIdJpa(@Nonnull Long clientId) {
        requireNonNull(clientId);

        Client client = clientJpaRepository
                .findById(clientId)
                .orElseThrow(NoClientFoundException::new);

        ClientDto clientDto = client2ClientDto.apply(client);

        return clientDto;
    }

    @Override
    public Set<ClientDto> getAll() {
        return clientDtos;
    }

    @Override
    public Set<ClientDto> getByFilter(@Nonnull String filter) {
        requireNonNull(filter);

        clientDtos.stream()
                .findAny()
                .orElseThrow(() -> new NoClientsFoundException());

        return clientDtos;
    }

}
