package com.nepgroup.stoneroos.devops_api;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevopsApiApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(DevopsApiApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }

}
