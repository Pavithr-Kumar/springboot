package com.zettamine.boot.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jdbc")
@Profile("qa")
public class DBConnetion {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConnetion [driver=" + driver + ", url=" + url + ", user=" + user + ", password=" + password + "]";
	}

}
