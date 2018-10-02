package com.tm.perf.tool.dao;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.performance")
public class performanceDatabaseConfig {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String initialSize;
    private String maxActive;

    @Bean(name = "dsPerformance")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(getUrl());
        ds.setUsername(getUsername());
        ds.setPassword(getPassword());
        ds.setInitialSize(Integer.parseInt(getInitialSize()));
        ds.setMaxTotal(Integer.parseInt(getMaxActive()));
        ds.setDriverClassName(getDriverClassName());
        return ds;
    }

    @Bean(name = "jdbcPerformance")
    public JdbcTemplate jdbcTemplate(DataSource dsItems) {
        dsItems = dataSource();
        System.out.println("PerformanceDatabaseConfig.jdbcTemplate()" + dsItems.toString());
        return new JdbcTemplate(dsItems);
    }
    
    @Bean(name = "namedJdbcPerformance")
    public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dsItems) {
        System.out.println(
                "PerformanceDatabaseConfig.namedJdbcEzedebit()" + dsItems.toString() + " , driver=" + getDriverClassName());
        return new NamedParameterJdbcTemplate(dsItems);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(String initialSize) {
        this.initialSize = initialSize;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

}
