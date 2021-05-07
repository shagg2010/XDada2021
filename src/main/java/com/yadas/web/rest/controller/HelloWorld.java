package com.yadas.web.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping(value = "/sayHello")
    public List<String> sayHelloToDCU(){
        List<String> list = new ArrayList<>();
        list.add("Superman!");
        list.add("Wonder Woman!");
        list.add("Batman!");
        list.add("Flash!");
        list.add("Shazam!");
        return list;
    }
}