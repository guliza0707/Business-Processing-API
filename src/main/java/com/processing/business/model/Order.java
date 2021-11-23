package com.processing.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "orders", schema = "business", catalog = "business")
public class Order {


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private Collection<OrderItem> orderItems;

    @Basic
    @Column(name = "ordered_date", nullable = true)
    private Date orderedDate;

    @Basic
    @Column(name = "total_sum", nullable = true, precision = 0)
    private BigInteger totalSum;



    @Basic
    @Column(name = "status", nullable = true, length = -1)
    private String status;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return Objects.equals(id, that.id) && Objects.equals(client.getId(), that.client.getId()) && Objects.equals(orderedDate, that.orderedDate) && Objects.equals(totalSum, that.totalSum) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client.getId(), orderedDate, totalSum, status);
    }
}
