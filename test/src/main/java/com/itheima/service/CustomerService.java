package com.itheima.service;

import com.itheima.domian.Customer;
import org.springframework.beans.factory.config.CustomEditorConfigurer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void updateCustomer(Customer customer);

}
