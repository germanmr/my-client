package com.mycompany.myclient.service;

import com.mycompany.myclient.dto.ClientDto;
import com.mycompany.myclient.model.Client;
import com.mycompany.myclient.repository.ClientJpaRepository;
import com.mycompany.myclient.repository.ClientRepository;
import com.mycompany.myclient.service.function.Client2ClientDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultClientServiceTest {

    private static final long CLIENT_ID = 1L;

    private static String CLIENT_NAME = "German";

    @InjectMocks
    private DefaultClientService defaultClientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientJpaRepository clientJpaRepository;

    @Mock
    private Client2ClientDto client2ClientDto;

    @Test
    public void getById() {

        Client client = new Client(CLIENT_NAME);
        client.setId(CLIENT_ID);

        when(clientRepository.findById(CLIENT_ID)).thenReturn(client);

        when(client2ClientDto.apply(client)).thenReturn(new ClientDto(CLIENT_ID, CLIENT_NAME));

        ClientDto actual = defaultClientService.getById(CLIENT_ID);

        assertEquals(new ClientDto(CLIENT_ID, CLIENT_NAME), actual);
    }

//    @Override
//    public ClientDto getById(@Nonnull Long clientId) {
//        requireNonNull(clientId);
//
//        Client client = clientRepository.findById(clientId);
//
//        ClientDto clientDto = client2ClientDto.apply(client);
//
//        return clientDto;
//
//    }


}
