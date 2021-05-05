package com.hibernate.testing.service.impl.test.facebook.intefraces;

import com.hibernate.testing.domain.test.facebook.Customer;

public interface CustomerService {

    Customer add(Customer customer);

    Customer getCustomerByEmail(String email);
}
