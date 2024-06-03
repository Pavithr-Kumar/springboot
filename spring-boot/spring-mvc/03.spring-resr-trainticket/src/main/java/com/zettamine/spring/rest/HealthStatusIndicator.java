package com.zettamine.spring.rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthStatusIndicator implements HealthIndicator {

	@Override
	public Health health() {
		Health health= checkInternet()?Health.up().withDetail("active", "Working fine").build()
				                      :Health.down().withDetail("inactive", "Not working").build();
		return health;
	}
	
	public boolean checkInternet() {
		try {
			URL url= new URL("https://www.google.com");
			URLConnection uCon = url.openConnection();
			uCon.connect();
			return true;
		} catch (IOException e) {
			
			return false;
		}
		
	}

}
