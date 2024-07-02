package org.example.spring_mvc_without_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
      public String hello(){
        return "Hello";
    }
}
