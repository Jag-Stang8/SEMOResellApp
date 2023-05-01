package com.redacted.semoresellapp.service;

import com.redacted.semoresellapp.model.Customer;
import com.redacted.semoresellapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> searchCustomers(String keyword) {
        return customerRepository.findByEmailContainingIgnoreCase(keyword);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    //Add other methods as needed
}
