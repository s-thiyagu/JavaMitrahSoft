package com.Practise.Spring.Boot.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(HttpSession http , HttpServletRequest request){
        return "Telsco HttpServeltResquest  : "+request.getSession().getId()+"Hello Dev! This is SessionID : "+http.getId()+"let see what comes in output = "+http.toString() ;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
