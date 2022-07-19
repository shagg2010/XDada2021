package com.yadas.web.rest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${application.database.url}")
    private String databaseURL;

    @Value("${application.database.user}")
    private String databaseUser;

    @Value("${application.database.password}")
    private String databasePassword;

    @Value("${application.database.driver}")
    private String databaseDriver;

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName(this.databaseDriver)
                .url(this.databaseURL)
                .username(this.databaseUser)
                .password(this.databasePassword)
                .build();
    }
}
