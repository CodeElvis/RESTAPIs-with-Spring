package com.example.ProjectCustomer.Controller;

import com.example.ProjectCustomer.Model.Customer;
import com.example.ProjectCustomer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/getallinfo")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/getinfo/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id).get();
    }

    @DeleteMapping("/deleteinfo/{id}")
    public boolean deleteCustomerById(@PathVariable int id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/updateinfo/{id}")
    public Customer updateCustomerById(@PathVariable("id") Integer id,
                                       @RequestBody Map<String, String> body) {


        Customer c = customerRepository.findById(id).get();
        c.setEmail(body.get("email"));
        c.setAddress(body.get("address"));
        c.setPhone(Integer.parseInt(body.get("phone")));
        customerRepository.save(c);
        return c;
    }

    @PostMapping("/addinfo")
    public Customer addCustomer(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String address = body.get("address");
        int phone = Integer.parseInt(body.get("phone"));
        Customer newcustomer = new Customer(email, address, phone);

        return customerRepository.save(newcustomer);
    }
}
