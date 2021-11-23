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
@Table(name = "products", schema = "business", catalog = "business")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private BigInteger price;

    @Basic
    @Column(name = "type", nullable = true, length = -1)
    private String type;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @JsonIgnore
    private Collection<OrderItem> orderItems;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type);
    }
}
