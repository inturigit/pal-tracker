package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomeController {

    private String message=null;

    //@Value("${welcome.message}")

    public WelcomeController(@Value("${welcome.message}") String message){
        this.message=message;
    }

    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }
}
