package com.itheima.web;

import com.itheima.domian.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class MyController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request){
        List<Customer> all = customerService.findAll();
        request.setAttribute("customers",all);
        return "list";
    }
    @RequestMapping("/findById")
    public String findById(HttpServletRequest request,Long custId){
        Customer customer = customerService.findCustomerById(custId);
        request.setAttribute("customer",customer);
        return "edit";
    }
    @RequestMapping("/update")
    public String update(Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/list.do";
    }
}
