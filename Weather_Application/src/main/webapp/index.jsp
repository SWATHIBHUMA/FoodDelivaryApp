<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weather App</title>
    <link rel="stylesheet" href="style.css">
    <script src="index.js"></script>
    <script src="practice.js"></script>
</head>
<body>

	<div class="main-container">
        <div class="container" id="humidity">
            <h1 class="text1">Humidity</h1>
            <img src="images/humidity-removebg-preview (1).png" alt="humid-image" class="humid-image">
            <p class="date" style="font-size: larger;"><strong>${humidity} %</strong></p>
        </div>
        
        <div class="container" id="weather">
            <h1 class="text1">Weather</h1>
            <form action="weatherServlet" method="post">
				<div class="search-container">
            		<input type="text" class="search-bar" placeholder="search city name" name="city"/>
            		<button class="search-button">Search</button>
        		</div>
			</form>
            <img src="images/Weatherimage.jpg" alt="weather-image" class="weather-image">
            <p class="date" style="font-size: larger;" ><strong>${temperature} °C</strong></p>
            <div class="city-div">
                <p class="city-name" style="font-size: larger;"><strong>${city}</strong></p>
                <p class="date" style="font-size: larger;"><strong>${date}</strong></p>
            </div>
        </div>
        
        <div class="container" id="wind-speed">
            <h1 class="text1">Wind-Speed</h1>
            <img src="images/wind 2.jpg" alt="weather-image" class="wind-image">
            <p class="date" style="font-size: larger;"><strong>${windSpeed} km/h</strong></p>
        </div>
        
    </div>
</body>
</html>