package com.hx.config;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by wangyaohui on 2017/6/2.
 */
@Configuration
public class MonitorConfig {
    @Bean(name = "postgresDb")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource postgresDataSource() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "postgresJdbcTemplate")
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDb") DataSource dsPostgres) {
        return new JdbcTemplate(dsPostgres);
    }
}
