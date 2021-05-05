package com.hibernate.testing.service.impl.test.facebook.impl;

import com.hibernate.testing.domain.test.facebook.Customer;
import com.hibernate.testing.repository.test.CustomerRepository;
import com.hibernate.testing.service.impl.test.facebook.intefraces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               PasswordEncoder encoder) {
        this.customerRepository = customerRepository;
        this.encoder = encoder;
    }

    @Override
    public Customer add(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
