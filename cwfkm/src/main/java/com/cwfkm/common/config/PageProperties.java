package com.cwfkm.common.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;
/**
 * @Configuration 描述的对象为一个配置对象,可以由
 * Spring对其管理.
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "db.page")
public class PageProperties {
	private int pageSize;
}


