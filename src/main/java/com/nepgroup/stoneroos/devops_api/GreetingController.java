package com.nepgroup.stoneroos.devops_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final RestClient restClient;

  public GreetingController(RestClient.Builder restClientBuilder) {
    this.restClient = restClientBuilder.baseUrl("https://ifconfig.me").build();
  }

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
      HttpServletRequest request) {
    String ipaddress = restClient.get().uri("/").retrieve().body(String.class);
    String clientip = request.getRemoteAddr();
    return new Greeting(ipaddress, clientip, String.format(template, name));
  }
}
