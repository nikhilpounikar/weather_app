package com.app.weather.Utils;

import org.springframework.stereotype.Service;

@Service
public class ExceptionHandler {
	
	public static void handleException(Exception e) {
		
		// handle various exeption
		e.printStackTrace();
		
	}

}
