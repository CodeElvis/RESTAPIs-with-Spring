package com.example.ProjectCustomer.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String address;
    private int phone;

    public Customer(String email, String address, int phone) {
        this.email = email;
        this.address = address;
        this.phone = phone;

    }

    public Customer() {

    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {return phone; }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
