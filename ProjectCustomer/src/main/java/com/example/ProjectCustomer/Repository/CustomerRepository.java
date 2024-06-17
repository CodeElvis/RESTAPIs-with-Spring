package com.example.ProjectCustomer.Repository;

import com.example.ProjectCustomer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
