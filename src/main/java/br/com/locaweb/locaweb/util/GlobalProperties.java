package br.com.locaweb.locaweb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class GlobalProperties {
	
	@Value("${HTTP_USERNAME}")
	private String HTTP_USERNAME;
	
	@Value("${UPI_TWITTER}")
	private String UPI_TWITTER;

	public String getUPI_TWITTER() {
		return UPI_TWITTER;
	}

	public void setUPI_TWITTER(String uPI_TWITTER) {
		UPI_TWITTER = uPI_TWITTER;
	}

	public String getHTTP_USERNAME() {
		return HTTP_USERNAME;
	}

	public void setHTTP_USERNAME(String hTTP_USERNAME) {
		HTTP_USERNAME = hTTP_USERNAME;
	}

	
	
	
}
