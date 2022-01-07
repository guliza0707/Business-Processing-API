package com.processing.business.rest;

import com.processing.business.model.Order;
import com.processing.business.model.Product;
import com.processing.business.repository.ProductRepository;
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
@RequestMapping("/api/product")


public class ProductResource {

     ProductRepository productRepository;

    @GetMapping("/{id}")
    ResponseEntity<Product> orderName(@PathVariable("id") Long id) {
        Optional<Product> optionalOrder = productRepository.findById(id);
        if(optionalOrder.isPresent()) {
            Product product = optionalOrder.get();
            log.info("Order paid by id: {}", id);
            return ResponseEntity.ok(product);
        }

        return ResponseEntity.ok(optionalOrder.isPresent() ? optionalOrder.get() : null);

    }
}
