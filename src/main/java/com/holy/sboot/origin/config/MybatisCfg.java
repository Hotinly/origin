package com.holy.sboot.origin.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 MyBatis
 * 
 * @author Holy
 * @date 2017年6月16日 下午1:56:30
 * @ref http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html
 * @ref http://www.mybatis.org/mybatis-3/configuration.html#settings
 */
@Configuration
public class MybatisCfg {

	@Bean
	public ConfigurationCustomizer mybatisConfigurationCustomizer() {
		return new ConfigurationCustomizer() {

			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				configuration.setMapUnderscoreToCamelCase(true);
			}

		};

	}
}

//public class MybatisCfg implements ConfigurationCustomizer {
//
//	@Override
//	public void customize(org.apache.ibatis.session.Configuration configuration) {
//		configuration.setMapUnderscoreToCamelCase(true);
//	}
//}
