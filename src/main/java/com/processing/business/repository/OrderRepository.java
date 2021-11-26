package com.processing.business.repository;

import com.processing.business.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(String number);

    @Override
    Optional<Order> findById(Long aLong);


}
