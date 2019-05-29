package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domian.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public List<Customer> findAll() {
        List<Customer> all = customerDao.findAll();
        return all;
    }

    public Customer findCustomerById(Long cusId) {
        return null;
    }

    public void updateCustomer(Customer customer) {

    }
}
