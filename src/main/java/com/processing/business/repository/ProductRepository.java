package com.processing.business.repository;

import com.processing.business.model.Order;
import com.processing.business.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}