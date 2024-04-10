package com.app.weather.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.weather.Configuration.RapidConfiguration;
import com.app.weather.Service.HttpService;
import com.app.weather.Utils.ExceptionHandler;
import com.app.weather.Utils.Utility;

@RestController
@RequestMapping({ "/weather/" })
public class WeatherController {

	@GetMapping("summary/{city}")
	public ResponseEntity<String> getForecastSummary(@RequestHeader("ClientId") String clientId,
			@RequestHeader("ClientSecret") String clientSecret, @PathVariable String city) {

		try {
			
			if (!Utility.validateAuthentication(clientId, clientSecret)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid authentication");
			}

			String url = RapidConfiguration.RAPID_API_URI + city + "/summary/";

			String summary = HttpService.fetchWeatherData(url);

			return ResponseEntity.ok(summary);

		} catch (Exception e) {

			ExceptionHandler.handleException(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An internal server error occurred. Please try again later.");
		}
	}

	@GetMapping("hourly/{city}")
	public ResponseEntity<String> getHourlyForecast(@RequestHeader("ClientId") String clientId,
			@RequestHeader("ClientSecret") String clientSecret, @PathVariable String city) {

		try {

			if (!Utility.validateAuthentication(clientId, clientSecret)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid authentication");
			}

			String url = RapidConfiguration.RAPID_API_URI + city + "/hourly/";

			String summary = HttpService.fetchWeatherData(url);

			return ResponseEntity.ok(summary);

		} catch (Exception e) {

			ExceptionHandler.handleException(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An internal server error occurred. Please try again later.");
		}

	}

}
