package com.app.weather.Configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RapidConfiguration {
	
	public static final String RAPID_API_HOST = "forecast9.p.rapidapi.com";
	public static final String RAPID_API_KEY = "ae125ff1e0mshbdb87a4c2679054p18a29ajsne0f19c18e1b4";

	public static final String RAPID_API_URI = "https://www.rapidapi.com/forecast/";
	
	public static final String RAPID_HOST_URI = "https://www.rapidapi.com";
	
	public static HttpHeaders getHeadersData() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", RAPID_API_KEY);
		headers.set("X-RapidAPI-Host", RAPID_API_HOST);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return headers;
	}
}
