package com.processing.business.rest;


import com.processing.business.model.Client;
import com.processing.business.model.Order;
import com.processing.business.repository.ClientRepository;
import com.processing.business.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderResource {

    OrderRepository orderRepository;

    @GetMapping("/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
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

    @GetMapping("/{id}/paid")
    ResponseEntity<Order> paidOrder(@PathVariable("id") Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus("PAID");
            orderRepository.save(order);
            log.info("Order paid by id: {}", id);
            return ResponseEntity.ok(order);
        }

        return ResponseEntity.ok(optionalOrder.isPresent() ? optionalOrder.get() : null);

    }

    @PutMapping("/{id}/paid")
    ResponseEntity<Order> updateOrderById(@PathVariable("id") Long id, @RequestBody Order order) {

        orderRepository.save(order);
        return ResponseEntity.ok(order);

    }

}



