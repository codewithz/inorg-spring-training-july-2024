package com.inorg.model;

import java.time.LocalDate;

public class Customer {

    private int id;
    private String name;
    private String email;
    private String accountType;
    private long contact;
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
