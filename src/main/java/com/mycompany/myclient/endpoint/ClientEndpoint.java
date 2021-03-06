package com.mycompany.myclient.endpoint;

import com.mycompany.myclient.dto.ClientDto;
import com.mycompany.myclient.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("client")
public class ClientEndpoint implements Client {

    private final ClientService clientService;

    @Inject
    public ClientEndpoint(@Nonnull ClientService clientService) {
        this.clientService = requireNonNull(clientService);
    }

    @Override
    @GetMapping("/{id}")
    public ClientDto get(@Nonnull @PathVariable("id") Long clientId) {
        return clientService.getByIdJpa(requireNonNull(clientId));
    }

    @Override
    @GetMapping("/all")
    public Set<ClientDto> getAll() {
        return clientService.getAll();
    }

    @Override
    @GetMapping("/filter/{filter}")
    public Set<ClientDto> getByName(@NotEmpty @PathVariable("filter") String filter) {
        return clientService.getByFilter(requireNonNull(filter));
    }

}
