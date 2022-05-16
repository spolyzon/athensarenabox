package com.athensarenabox.subscription.mappers;

import com.athensarenabox.subscription.daos.ClientDao;
import com.athensarenabox.subscription.models.client.NewClientRegistrationModel;
import com.athensarenabox.subscription.models.client.ReadClientDetailsModel;

import java.time.LocalDate;

public class ClientMapper {

    public static ReadClientDetailsModel mapFromDaoToModel(ClientDao clientDao) {
        ReadClientDetailsModel readClientDetailsModel = new ReadClientDetailsModel();

        readClientDetailsModel.setFirstName(clientDao.getFirstName());
        readClientDetailsModel.setLastName(clientDao.getLastName());
        readClientDetailsModel.setMobile(clientDao.getMobile());
        readClientDetailsModel.setEmail(clientDao.getEmail());
        readClientDetailsModel.setSubscription(clientDao.getRegistrationDate());

        return readClientDetailsModel;
    }

    public static ClientDao mapFromModelToDao(NewClientRegistrationModel newClientRegistrationModel) {
        ClientDao clientDao = new ClientDao();

        clientDao.setMobile(newClientRegistrationModel.getMobile());
        clientDao.setFirstName(newClientRegistrationModel.getFirstName());
        clientDao.setLastName(newClientRegistrationModel.getLastName());
        clientDao.setEmail(newClientRegistrationModel.getEmail());
        clientDao.setRegistrationDate(LocalDate.now());

        return clientDao;
    }
}
