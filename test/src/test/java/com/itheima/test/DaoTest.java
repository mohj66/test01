package com.itheima.test;

import com.itheima.dao.CustomerDao;
import com.itheima.domian.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DaoTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomerDao mapper = sqlSession.getMapper(CustomerDao.class);
        List<Customer> all = mapper.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
}
