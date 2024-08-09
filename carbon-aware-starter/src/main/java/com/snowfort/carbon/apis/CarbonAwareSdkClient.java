package com.snowfort.carbon.apis;

import com.snowfort.carbon.config.CarbonAwareProperties;
import com.snowfort.carbon.models.Emissions;
import com.snowfort.carbon.sci.CarbonAwareSdkMarginalEmissionsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class CarbonAwareSdkClient {

    private RestTemplate restTemplate;
    private CarbonAwareProperties props;
    private CarbonEmissionsParams params;


    private static final Logger log = LoggerFactory.getLogger(CarbonAwareSdkClient.class);

    public CarbonAwareSdkClient(RestTemplate restTemplate, CarbonAwareProperties props, CarbonEmissionsParams params) {
        this.restTemplate = restTemplate;
        this.props = props;
        this.params = params;
    }

    public List<Emissions> emissionsForLocation() {
        String url = props.getEndpoint() + "/emissions/bylocation?location=" + params.getLocation();
        log.info ("emissionsForLocation endpoint is "+url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        log.info ("headers passing token  endpoint is "+headers);


        ResponseEntity<List<Emissions>> response = restTemplate.exchange(url, GET, request, new ParameterizedTypeReference<>() {
        });

        return response.getBody();
    }
}
