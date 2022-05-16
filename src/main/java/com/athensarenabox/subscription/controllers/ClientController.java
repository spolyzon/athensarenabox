package com.athensarenabox.subscription.controllers;

import com.athensarenabox.subscription.models.client.NewClientRegistrationModel;
import com.athensarenabox.subscription.models.client.ReadClientDetailsModel;
import com.athensarenabox.subscription.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ReadClientDetailsModel>> retrieveAllClients() {
        return ResponseEntity.ok(clientService.retrieveAllClients());
    }

    @GetMapping("/{mobile}")
    public ResponseEntity<ReadClientDetailsModel> retrieveClientByMobile(@PathVariable("mobile") String mobile) {
        return ResponseEntity.ok(clientService.retrieveClientByMobile(mobile));
    }

    @PostMapping
    public ResponseEntity<?> registerNewClient(@RequestBody NewClientRegistrationModel newClient) {
        clientService.registerNewClient(newClient);
        return ResponseEntity.status(CREATED).build();
    }

//    @PutMapping
//    public ResponseEntity<?> updateClientDetails(@RequestBody NewClientRegistrationModel updatedClientDetails) {
//        clientService.updateClientDetails(updatedClientDetails);
//        return ResponseEntity.status(NO_CONTENT).build();
//    }
//
//    @DeleteMapping("/{mobile}")
//    public ResponseEntity<?> deleteClientByMobile(@PathVariable("mobile") String mobile) {
//        clientService.deleteClientByMobile(mobile);
//        return ResponseEntity.status(NO_CONTENT).build();
//    }
}
