package com.login.springSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/home")
    public String home(){
        return "Welcome to home !";
    }

}
