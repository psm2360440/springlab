package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item")

public class ItemController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    String dir = "item/";

    //127.0.0.1/item
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(100, "pants", 10000, "a.jpg", new Date()));
        list.add(new Item(101, "pants", 20000, "b.jpg", new Date()));
        list.add(new Item(102, "pants", 30000, "c.jpg", new Date()));
        list.add(new Item(103, "pants", 40000, "d.jpg", new Date()));
        list.add(new Item(104, "pants", 50000, "e.jpg", new Date()));


        model.addAttribute("allitem", list);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "all");
        return "index";
    }

}