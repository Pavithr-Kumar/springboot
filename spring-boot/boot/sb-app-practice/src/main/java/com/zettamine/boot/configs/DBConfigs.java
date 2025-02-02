package com.zettamine.boot.configs;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties
//@PropertySource(value = "classpath:dbconfig.properties")
public class DBConfigs {
	
	@Value("#{employeeService.getName()}")
	private String changedName;
	private String url;
	DBConfigs(){
		LoggerFactory.getLogger(DBConfigs.class).info("\033[32mDB configs Bean\033[0m");
	}
	
	public String getDriver() {
		return changedName;
	}
	public void setCha(String driver) {
		this.changedName = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
