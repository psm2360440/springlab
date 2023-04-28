package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

//import static com.sun.java.util.jar.pack.Utils.log;

@Slf4j
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

    @Autowired
    ItemService service;
    @RequestMapping("/all")
    public String all(Model model) {

        List<Item> list = null;

        try {
            list = service.get();
            for(Item obj:list){
                log.info(obj.toString());
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        model.addAttribute("allitem", list);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "all");
        return "index";
    }

}
