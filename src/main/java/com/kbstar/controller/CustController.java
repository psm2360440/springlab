package com.kbstar.controller;

import com.kbstar.dto.Cust;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/cust")
//'/cust'로 호출되면 모두 CustController가 처리한다는 것을 의미
public class CustController {
    //단순하게 컨솔에 로그를 찍을 때 사용하는 방법
    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    String dir = "cust/";

    //127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "center");
        //logger.info("-------------------------------------------------------");
        Random r = new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+"");
        //must be in string format
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model, String id) {
        Cust cust = new Cust(id, "xxx", "namename");
        model.addAttribute("gcust", cust);

        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "get");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model) {

        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james"));
        list.add(new Cust("id02", "pwd02", "Harry"));
        list.add(new Cust("id03", "pwd03", "Ron"));
        list.add(new Cust("id04", "pwd04", "Malfoy"));
        list.add(new Cust("id05", "pwd05", "Smith"));

        model.addAttribute("clist", list);

        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "all");
        return "index";
    }

}
