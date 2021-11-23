package com.processing.business.rest;


import com.processing.business.model.Order;
import com.processing.business.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderResource {

    OrderRepository orderRepository;

    public OrderResource(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    @GetMapping("/{id}")
    ResponseEntity<Order> getClientById(@PathVariable("id") Long id) {
        try {
            Optional<Order> optionalOrder = orderRepository.findById(id);
            if(optionalOrder.isPresent()) {
                log.info("Get client by id: {}", id);
                return ResponseEntity.ok(optionalOrder.get());
            }
        } catch (Exception exception) {
            log.error("Exception: {}", exception.getMessage());
            log.error("Exception: {}", exception.getStackTrace());
        }
        log.error("Get no client by id: {}", id);
        return ResponseEntity.badRequest().body(new Order());
    }
}
