package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingApi {

//    ForecastService forecastService;
//
//    public GreetingApi(ForecastService forecastService) {
//        this.forecastService = forecastService;
//    }

    @GetMapping("/greeting/{name}")
    public String sayHello(@PathVariable String name) {
//        String forecast = forecastService.getWeather();
        return String.format("Hello, %s!  It looks like the weather will be %s", name, " Good Day");
    }

    @GetMapping(value = "/emitCarbon")
    public void emitCarbon() {
        int iterations = 1_000_000; // Number of iterations (you can adjust this for more/less load)
        int dataSize = 10_000; // Size of data array (adjust to increase memory usage)

        // Initialize a large array to create memory load
        double[] data = new double[dataSize];

        // Start the load-intensive loop
        for (int i = 0; i < iterations; i++) {
            // Perform a complex calculation (e.g., matrix-like operations)
            for (int j = 0; j < data.length; j++) {
                data[j] = Math.sin(j) * Math.cos(i) * Math.tan(dataSize - j);
            }

            // Sum all values in the array (another CPU-intensive task)
            double sum = 0;
            for (double value : data) {
                sum += value;
            }

            // Print the result of the current iteration (optional)
            if (i % 100_000 == 0) { // Print every 100,000 iterations to avoid too much output
                System.out.printf("Iteration %d: Sum = %.5f%n", i, sum);
            }
        }

        System.out.println("Load-intensive loop completed.");
    }

}
