package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

//    @Value("${welcome.message}")
//    String message;
//
//    @Value("${welcome.message2}")
//    String message2;
//


    @GetMapping("/")
    public String sayHello() {
        return "Hello from the review environment";
    }
}