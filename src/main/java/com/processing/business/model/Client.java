package com.processing.business.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.CustomLog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "clients", schema = "business")
public class Client {


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    private String firstName;

    @OneToMany(mappedBy = "client", orphanRemoval = true)
    @JsonIgnore
    private Collection<Order> orders;

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)

    private String lastName;

    @Basic
    @Column(name = "card_number", nullable = false, length = 50)
    private String cardNumber;

    @Basic
    @Column(name = "account_number", nullable = false, length = 50)
    private String accountNumber;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, cardNumber, accountNumber);
    }
}
