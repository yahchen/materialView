package com.hx.syncer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by yahchen on 2017/10/29.
 */
@EnableJpaRepositories(basePackages = "com.hx.syncer.dao")
@EntityScan(basePackages = "com.hx.syncer.bean")
@Configuration
public class JpaConfig {
}
