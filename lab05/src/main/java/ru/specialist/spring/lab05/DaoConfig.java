package ru.specialist.spring.lab05;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.specialist.spring.lab05.dao.CourseDAO;
import ru.specialist.spring.lab05.dao.JdbcCourseDAO;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class DaoConfig {
    @Autowired
    private Environment env;

    // @Bean(destroyMethod = "close")
    // no need for close() or shutdown()
    @Bean
    public DataSource webDataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(webDataSource());
    }

    @Bean
    public CourseDAO courseDAO() {
        JdbcCourseDAO dao = new JdbcCourseDAO();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
