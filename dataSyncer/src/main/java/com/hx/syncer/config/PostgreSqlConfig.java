package com.hx.syncer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by wangyaohui on 2017/6/2.
 */
@EnableJpaRepositories(basePackages = "com.hx.syncer.dao")
@EntityScan(basePackages = "com.hx.syncer.bean")
@Configuration
public class PostgreSqlConfig {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 数据库配置，读取applicatioin.properties中前缀为spring.datasource的配置
     * @return
     */
    @Bean(name = "postgresDb")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource postgresDataSource() {
        return  DataSourceBuilder.create().build();
    }

    /**
     *
     * @param dsPostgres
     * @return
     */
    @Bean(name = "postgresJdbcTemplate")
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDb") DataSource dsPostgres) {
        return new JdbcTemplate(dsPostgres);
    }
}
