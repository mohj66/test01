package com.itheima.dao;

import com.itheima.domian.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();
    Customer findCustomerById(Long cusId);
    void updateCustomer(Customer customer);
}
