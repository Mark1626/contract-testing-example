package com.mark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MathController {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/calculate")
  public String checkOddEven(@RequestParam("number") Integer number) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        "http://localhost:8080/validate/odd-number?number=" + number,
        HttpMethod.GET,
        new HttpEntity<>(httpHeaders),
        String.class
    );

    return responseEntity.getBody();
  }

}
