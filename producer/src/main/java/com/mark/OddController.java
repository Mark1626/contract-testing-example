package com.mark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OddController {

  @GetMapping("/validate/odd-number")
  public String isOddPrime(@RequestParam("number") Integer number) {
    return number % 2 == 0 ? "Even" : "Odd";
  }
}