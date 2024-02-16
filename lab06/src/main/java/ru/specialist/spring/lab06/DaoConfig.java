package ru.specialist.spring.lab06;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.specialist.spring.lab06.dao.CourseDAO;
import ru.specialist.spring.lab06.dao.HibernateCourseDAO;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("application.properties")
public class DaoConfig {
    @Autowired
    private Environment env;

    @Bean
    public CourseDAO courseDAO() {
        return new HibernateCourseDAO(sessionFactory().getObject());
    }

    // @Bean(destroyMethod = "close")
    // no need for close() or shutdown()
    @Bean
    public DataSource dataSource() {
        var dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        var sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("ru.specialist.spring.lab06.dao");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.max_fetch_depth", env.getRequiredProperty("hibernate.max_fetch_depth"));
        properties.put("hibernate.max_fetch_size", env.getRequiredProperty("hibernate.max_fetch_size"));
        properties.put("hibernate.max_batch_size", env.getRequiredProperty("hibernate.max_batch_size"));
        properties.put("hibernate.hibernate.jdbc.lob.non_contextual_creation", env.getRequiredProperty("hibernate.jdbc.lob.non_contextual_creation"));
        return properties;
    }

}

