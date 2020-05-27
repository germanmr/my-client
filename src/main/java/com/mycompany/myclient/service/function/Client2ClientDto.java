package com.mycompany.myclient.service.function;

import com.mycompany.myclient.dto.ClientDto;
import com.mycompany.myclient.model.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * We will use this function:
 * <br> either convert one thing to another
 * <br>2)  different outcome than income!</br>
 */
@Component
public class Client2ClientDto implements Function<Client, ClientDto> {

    @Override
    public ClientDto apply(Client client) {

        Long id = client.getId();
        String name = client.getName();

        return new ClientDto(id, name);

    }
}
