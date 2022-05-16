package com.athensarenabox.subscription.controllers;

import com.athensarenabox.subscription.models.client.ReadClientDetailsModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientControllerTest {

    @Autowired
    private ClientController underTest;

    @Test
    public void theOneWhereTheClientControllerIsInitialisedBySpring() {
        assertThat(underTest, is(notNullValue()));
    }

    @Test
    public void theOneWhereWeRetrieveAllClients() {
        ResponseEntity<List<ReadClientDetailsModel>> response = underTest.retrieveAllClients();

        assertThat(response.getStatusCode(), is(OK));

        List<ReadClientDetailsModel> allClients = response.getBody();


        ReadClientDetailsModel client1 = new ReadClientDetailsModel("first", "client", "1234567890", "client@first.com", LocalDate.of(2022, 4, 16));
        ReadClientDetailsModel client2 = new ReadClientDetailsModel("second", "client", "0987654321", "client@second.com", LocalDate.of(2022, 4, 16));

        assertThat(allClients.contains(client1), is(true));
        assertThat(allClients.contains(client2), is(true));
    }

    @Test
    public void theOneWhereWeRetrieveAClientByMobile() {
        ResponseEntity<ReadClientDetailsModel> response = underTest.retrieveClientByMobile("1234567890");

        assertThat(response.getStatusCode(), is(OK));

        ReadClientDetailsModel client = response.getBody();
        assertThat(client.getFirstName(), is("first"));
        assertThat(client.getLastName(), is("client"));
        assertThat(client.getEmail(), is("client@first.com"));
        assertThat(client.getMobile(), is("1234567890"));
        assertThat(client.getSubscription(), is(LocalDate.of(2022, 4, 16)));
    }

//    @Test
//    public void theOneWhereWeCreateNewClient() {
//        CreateNewClientModel clientDetails = new CreateNewClientModel("spyros", "polyzonis", "6900000001", "test@test.com");
//
//        ResponseEntity<?> creationResponse = underTest.createNewClient(clientDetails);
//        assertThat(creationResponse.getStatusCode(), is(CREATED));
//
//        List<ReadClientDetailsModel> allClients = underTest.retrieveAllClients().getBody();
//        assertThat(allClients.size(), is(3));
//
//        ReadClientDetailsModel newlyAddedClient = underTest.retrieveClientByMobile("6900000001").getBody();
//        assertThat(newlyAddedClient.getFirstName(), is("spyros"));
//        assertThat(newlyAddedClient.getLastName(), is("polyzonis"));
//        assertThat(newlyAddedClient.getEmail(), is("test@test.com"));
//        assertThat(newlyAddedClient.getMobile(), is("6900000001"));
//    }
//
//    @Test
//    public void theOneWhereWeUpdateExistingClientDetails() {
//        CreateNewClientModel updatedClientDetails = new CreateNewClientModel();
//        updatedClientDetails.setEmail("admin@admin.com");
//        updatedClientDetails.setMobile("6900000001");
//
//        ResponseEntity<?> response = underTest.updateClientDetails(updatedClientDetails);
//
//        assertThat(response.getStatusCode(), is(NO_CONTENT));
//    }

//    @Test
//    public void theOneWhereWeDeleteClientByMobile() {
//        ResponseEntity<?> response = underTest.deleteClientByMobile("6900000001");
//
//        assertThat(response.getStatusCode(), is(NO_CONTENT));
//    }
}