package com.konkov.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @RequestMapping("/")
    public String showFirstView(){
        return "firstView";
    }
}
