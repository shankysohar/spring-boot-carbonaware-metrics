package com.snowfort.carbon.apis;

import com.snowfort.carbon.models.Emissions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;

public class SampleAPIRestCall {

    public static void main (String[] args) {
        System.setProperty("logging.level.org.springframework", "DEBUG");

       // String urltoken = "https://api.watttime.org/login";
        String urltoken = "https://api.watttime.org/v3/historical?region=CAISO_NORTH&start=2024-08-06T21%3a21%3a27.2518447%2b00%3a00&end=2024-08-07T01%3a21%3a27.2518447%2b00%3a00&signal_type=co2_moer";

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("shankysohar1", "Welcome@2024");
        HttpEntity request = new HttpEntity(headers);


        ResponseEntity<String> response = new RestTemplate().exchange(urltoken, GET, request, new ParameterizedTypeReference<>() {
        });

        String token = response.getBody();
        System.out.println(token);

//
//        String url = "https://api.watttime.org/v3/historical?region=CAISO_NORTH&start=2024-08-06T21%3a21%3a27.2518447%2b00%3a00&end=2024-08-07T01%3a21%3a27.2518447%2b00%3a00&signal_type=co2_moer";
//        //String url = "https://api.watttime.org/v3/region-from-loc?latitude=42.372&longitude=-72.519&signal_type=co2_moer";
//        HttpHeaders headers1 = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        headers1.setBearerAuth(token);
//
//        HttpEntity request1 = new HttpEntity(headers1);
//
////        Map<String, String> params = new HashMap<String, String>();
////        params.put("region", "CAISO_NORTH");
////        params.put("start", "2023-11-16");
////        params.put("end", "2024-07-30");
////        params.put("signal_type", "co2_moer");
//
//        HttpEntity<String> response11 = new RestTemplate().exchange(url, GET, request1, String.class);
//
//
//
//        System.out.println(response11);

    }


//    public static void tryChatGPTSample() {
//        String url = "https://api.watttime.org/v3/historical";
//
//        // Build the URL with query parameters
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//                .queryParam("region", "CAISO_NORTH")
//                .queryParam("start", "2023-11-16")
//                .queryParam("end", "2024-07-30")
//                .queryParam("signal_type", "co2_moer");
//
//        String finalUrl = builder.toUriString();
//
//        // Set up headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth("shankysohar1", "Welcome@2024");  // Make sure you include password or use OAuth if needed
//
//        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
//
//        // Create RestTemplate and execute request
//        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<String> response11 = restTemplate.exchange(finalUrl, GET, request1, String.class, params);
//
//        // Print the response
//        System.out.println(response);
//    }
    }

