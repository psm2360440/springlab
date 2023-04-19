package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://127.0.0.1/
@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return  "index";
    }

    @RequestMapping("/nex")
    public String next(){
        return  "next";
    }
}
