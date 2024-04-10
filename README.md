# weather_app

# WeatherController

This Java class implements a RESTful API for fetching weather forecast data using the RapidAPI service. It provides endpoints to retrieve the weather forecast summary and hourly forecast details for any city.

## Endpoints

### Get Weather Forecast Summary
- **URL**: `/weather/summary/{city}`
- **Method**: GET
- **PathVariable**:
  - `city` (required): The name of the city for which the weather forecast summary is requested.
- **Headers**:
  - `ClientId`: Random client ID for authentication.
  - `ClientSecret`: Random client secret for authentication.
- **Response**:
  - HTTP Status 200 OK: Returns the weather forecast summary of the specified city in JSON format.
  - HTTP Status 401 Unauthorized: Indicates invalid authentication.

### Get Hourly Weather Forecast
- **URL**: `/weather/hourly/{city}`
- **Method**: GET
- **PathVariable**:
  - `city` (required): The name of the city for which the hourly weather forecast details are requested.
- **Headers**:
  - `ClientId`: Random client ID for authentication.
  - `ClientSecret`: Random client secret for authentication.
- **Response**:
  - HTTP Status 200 OK: Returns the hourly weather forecast details of the specified city in JSON format.
  - HTTP Status 401 Unauthorized: Indicates invalid authentication.

## Implementation Details

- The authentication for accessing the APIs is header-based with random client ID and client secret.
- The weather forecast data is fetched from the RapidAPI service.
- The `validateAuthentication` method can be customized to implement the desired authentication logic.
- The `fetchWeatherData` method retrieves weather data from the RapidAPI service using a `RestTemplate`.

