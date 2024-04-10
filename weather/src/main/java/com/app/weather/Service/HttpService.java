package com.app.weather.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.weather.Configuration.RapidConfiguration;
import com.app.weather.Utils.ExceptionHandler;

@Service
public class HttpService {

	// Helper method to fetch weather data from RapidAPI
	public static String fetchWeatherData(String apiUrl) {

		try {

			HttpHeaders headers = RapidConfiguration.getHeadersData();

			HttpEntity<String> entity = new HttpEntity<>(null, headers);

			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

			HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				
				return responseEntity.getBody();
				
			} else if (statusCode == HttpStatus.PERMANENT_REDIRECT) {
				// Follow the redirect
				String redirectUrl = RapidConfiguration.RAPID_HOST_URI
						+ responseEntity.getHeaders().getLocation().toString();
				return fetchWeatherData(redirectUrl);
			} else {
				// Handle error cases here
				return "Error occurred while fetching data";
			}

		} catch (Exception e) {

			ExceptionHandler.handleException(e);
			
			return "Something Went wrong";
		}

	}

}
