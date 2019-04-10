package com.mark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

  @GetMapping(
      value = "/account",
      produces = "application/json"
  )
  public UserInfo isOddPrime(
      @RequestParam("name") String name,
      @RequestParam("password") String password) {
    if (name.equals("mark")) {
      return new UserInfo("mark", "mark@abc.com", "password123", 123L,
          "2019-01-01", 123L);
    } else {
      return new UserInfo("nimalan", "nimalan@abcd.com", "password123", 234L,
          "2019-01-02", 234L);
    }
  }

  public class UserInfo {

    private String name;
    private String email;
    private String password;
    private Long id;
    private String lastLoggedIn;
    private Long phoneNumber;

    UserInfo(String name, String email, String password, Long id, String lastLoggedIn,
        Long phoneNumber) {
      this.name = name;
      this.email = email;

      this.password = password;
      this.id = id;
      this.lastLoggedIn = lastLoggedIn;
      this.phoneNumber = phoneNumber;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getLastLoggedIn() {
      return lastLoggedIn;
    }

    public void setLastLoggedIn(String lastLoggedIn) {
      this.lastLoggedIn = lastLoggedIn;
    }

    public Long getPhoneNumber() {
      return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
      this.phoneNumber = phoneNumber;
    }
  }
}
