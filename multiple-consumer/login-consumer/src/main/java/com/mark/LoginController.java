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
public class LoginController {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/login")
  public String checkOddEven(
      @RequestParam("name") String name,
      @RequestParam("password") String password) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        "http://localhost:8080/account?name=" + name + "&password=" + password,
        HttpMethod.GET,
        new HttpEntity<>(httpHeaders),
        String.class
    );

    // Do some operation

    return responseEntity.getBody();
  }

  public class UserDetails {
    private String name;
    private String password;

    public UserDetails(String name, String password) {
      this.name = name;
      this.password = password;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

}
