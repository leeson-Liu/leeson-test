//package config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// * @author liubin
// * @create 2020-09-07 13:36
// * @desc
// **/
//@Configuration
//public class MySqlConfig {
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public HikariConfig redshiftConf() {
//        return new HikariConfig();
//    }
//
//
//    @Bean(name = "jdbcTemplateMysql")
//    @Autowired
//    public JdbcTemplate jdbcTemplateRedshift(HikariConfig redshiftConf) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(new HikariDataSource(redshiftConf));
//        jdbcTemplate.setQueryTimeout(150);
//        return jdbcTemplate;
//    }
//
//}
