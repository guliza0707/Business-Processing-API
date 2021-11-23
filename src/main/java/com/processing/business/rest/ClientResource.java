package com.processing.business.rest;


import com.processing.business.model.Client;
import com.processing.business.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/client")
public class ClientResource {

    ClientRepository clientRepository;

    @GetMapping("/{id}")
    ResponseEntity<?> getClientById(@PathVariable("id") Long id) {
        Optional<Client> client = null;
        try {
            client = clientRepository.findById(id);
            if(client.isPresent()) {
                log.info("Get client by id: {}", id);
                return ResponseEntity.ok(client.get());
            }
        } catch (Exception exception) {
            log.error("Exception: {}", exception.getMessage());
        }
        log.error("Get no client by id: {}", id);
        return ResponseEntity.badRequest().body(client);
    }
}
