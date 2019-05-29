package com.itheima.test;

import com.itheima.domian.Customer;
import com.itheima.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService bean = applicationContext.getBean("customerServiceImpl", CustomerService.class);
        List<Customer> all = bean.findAll();

    }
}
