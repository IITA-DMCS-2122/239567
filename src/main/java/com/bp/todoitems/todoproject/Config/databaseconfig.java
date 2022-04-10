package com.bp.todoitems.todoproject.Config;

import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bp.todoitems.todoproject.Repository.Sql",
        entityManagerFactoryRef = "EntityManagerFactory",
        transactionManagerRef = "TransactionManager"
)
public class databaseconfig {

    @Primary
    @Bean("postgresDataSource")
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean EntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder.dataSource(postgresDataSource()).packages(TodoSqlEntity.class.getPackage().getName()).properties(properties).build();
    }
    @Primary
    @Bean("TransactionManager")
    public PlatformTransactionManager TransactionManager(
            final @Qualifier("EntityManagerFactory") LocalContainerEntityManagerFactoryBean memberEntityManagerFactory) {
        return new JpaTransactionManager(memberEntityManagerFactory.getObject());
    }

}
