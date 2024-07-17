package com.inorg.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
//Represents the Java class
@Entity(name = "Customer")
//Represents the DB Table
@Table(name = "customer")
public class Customer {
//    Represents the Primay Key
    @Id
//    For generating the sequence for the table
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1,
            initialValue = 1
    )
//    For getting the generated value
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private int id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name="email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true

    )
    private String email;
    @Column(
            name="account_type",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String accountType;
    @Column(
            name="contact",
            nullable = false,
            columnDefinition = "BIGINT"

    )
    private long contact;
    @Column(
            name="account_creation_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate accountCreationDate;

    public Customer() {
    }

    public Customer(int id, String name, String email, String accountType, long contact, LocalDate accountCreationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountType = accountType;
        this.contact = contact;
        this.accountCreationDate = accountCreationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accountType='" + accountType + '\'' +
                ", contact=" + contact +
                ", accountCreationDate=" + accountCreationDate +
                '}';
    }
}
