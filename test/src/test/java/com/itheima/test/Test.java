package com.itheima.test;

import com.itheima.dao.CustomerDao;
import com.itheima.domian.Customer;
import com.itheima.service.CustomerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {
    @Autowired
    private CustomerService customerService;
    @org.junit.Test
    public void demo1(){
        List<Customer> all = customerService.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
}
