package com.mycompany.myclient.service;


import com.mycompany.myclient.dto.ClientDto;
import com.mycompany.myclient.service.base.CrudService;

/**
 * This should be de default repository
 */
public interface ClientService extends CrudService<ClientDto, Long> {

    ClientDto getByIdJpa(Long clientId);

}
