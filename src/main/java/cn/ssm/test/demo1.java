package cn.ssm.test;

import cn.ssm.entity.Emp;
import cn.ssm.service.MybatisService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class demo1 {
    Logger log = Logger.getLogger(demo1.class);
    @Test
    public void test111() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MybatisService mybatisService = (MybatisService) ac.getBean("mybatisService");
        Emp emp = new Emp(3,"测试");
        mybatisService.add(emp);
    }
    @Test
    public void test22() throws SQLException {
    }

}
