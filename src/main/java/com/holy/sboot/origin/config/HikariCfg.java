package com.holy.sboot.origin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariCfg {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Bean
	public DataSource dataSource() {
		if (StringUtils.isEmpty(dbUrl)) {
			return new HikariDataSource();
		} else {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setJdbcUrl(dbUrl);
			return new HikariDataSource(hikariConfig);
		}

	}

}
