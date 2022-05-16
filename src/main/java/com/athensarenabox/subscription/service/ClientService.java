package com.athensarenabox.subscription.service;

import com.athensarenabox.subscription.daos.ClientDao;
import com.athensarenabox.subscription.exceptions.UnknownClientMobileReceived;
import com.athensarenabox.subscription.mappers.ClientMapper;
import com.athensarenabox.subscription.models.client.NewClientRegistrationModel;
import com.athensarenabox.subscription.models.client.ReadClientDetailsModel;
import com.athensarenabox.subscription.repositories.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ReadClientDetailsModel> retrieveAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::mapFromDaoToModel)
                .collect(toList());
    }

    public ReadClientDetailsModel retrieveClientByMobile(String mobile) {
        return clientRepository.findById(mobile)
                .map(ClientMapper::mapFromDaoToModel)
                .orElseThrow(() -> new UnknownClientMobileReceived(mobile));
    }

    public void registerNewClient(NewClientRegistrationModel newClient) {
        ClientDao newClientDao = ClientMapper.mapFromModelToDao(newClient);
        clientRepository.save(newClientDao);
    }

    public void updateClientDetails(NewClientRegistrationModel updatedClientDetails) {
        ClientDao updatedClientDao = ClientMapper.mapFromModelToDao(updatedClientDetails);
        clientRepository.save(updatedClientDao);
    }

    public void deleteClientByMobile(String mobile) {
        clientRepository.deleteById(mobile);
    }
}
