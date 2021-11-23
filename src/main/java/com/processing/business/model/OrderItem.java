package com.processing.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "order_items", schema = "business", catalog = "business")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = true)
    @JsonIgnore
    private Product product;

    @Basic
    @Column(name = "unit", nullable = true, length = -1)
    private String unit;


    @Basic
    @Column(name = "quantity", nullable = true, precision = 0)
    private BigInteger quantity;

    @Basic
    @Column(name = "sum", nullable = true, precision = 0)
    private BigInteger sum;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem that = (OrderItem) o;
        return Objects.equals(id, that.id) && Objects.equals(order.getId(), that.order.getId()) && Objects.equals(product.getId(), that.product.getId()) && Objects.equals(unit, that.unit) && Objects.equals(quantity, that.quantity) && Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order.getId(), product.getId(), unit, quantity, sum);
    }
}
