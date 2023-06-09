//package com.linjie.jdbctemplate;
///**
// * @author LinJie E-mail:ash-ali@163.com
// * @version 创建时间：2018年5月11日 下午4:42:55
// * 测试
// */
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class jdbc {
//    private JdbcTemplate jdbcTemplate;
//    private ApplicationContext context = null;
//
//    //初始化连接池
//    {
//        context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
//    }
//
//    //测试是否连接数据库
//    public void testIsConnect() throws SQLException {
//        DataSource dataSource = context.getBean(DataSource.class);
//        System.out.println("连接成功"+dataSource.getConnection());
//    }
//}
