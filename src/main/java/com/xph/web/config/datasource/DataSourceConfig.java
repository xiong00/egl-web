package com.xph.web.config.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
@Configuration
public class DataSourceConfig extends AbstractDataSourceConfig{

    @Bean
    @ConfigurationProperties(prefix= DB_DEFAULT_PREFIX)
    @Override
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix= DB_READ_PREFIX)
    @Override
    public DataSource readDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix= DB_WRITE_PREFIX)
    @Override
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().build();
    }
}
