package com.phonedirectory.app.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {
    @RequestMapping("/user")
    public String display(){
        return "hello springboot";
    }


}
