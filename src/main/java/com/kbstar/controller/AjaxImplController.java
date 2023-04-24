package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @RequestMapping("/checkid")
    public Object checkid(String id){
        int result = 0;
        if(id.equals("qqqq")||id.equals("aaaa")||id.equals("ssss")){
           result = 1;
        }else{
            result = 0;
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata(){

        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james"));
        list.add(new Cust("id02", "pwd02", "Harry"));
        list.add(new Cust("id03", "pwd03", "Ron"));
        list.add(new Cust("id04", "pwd04", "Malfoy"));
        list.add(new Cust("id05", "pwd05", "Smith"));

        //Java Object ---> JSON
        //JSON(JavaScript Object Notation)
        //[{}, {}, {},...]
        JSONArray ja = new JSONArray();

        for(Cust obj:list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName()+i);
            ja.add(jo);
        }

        return ja;
    }

    @RequestMapping("/markers")
    public Object markers(String loc){
        List<Marker> list = new ArrayList<>();
        if (loc.equals("s")){
            list.add(new Marker(100, "태평소국밥", "http://www.naver.com", 37.5244538, 127.0512581, "e.jpg", "s" ));
            list.add(new Marker(101, "오씨칼국수", "http://www.naver.com", 37.5744538, 127.0412581, "e.jpg", "s" ));
            list.add(new Marker(102, "시민칼국수", "http://www.naver.com", 37.5344538, 127.0012081, "e.jpg", "s" ));
        }else if (loc.equals("d")){
            list.add(new Marker(103, "태평소국밥", "https://map.naver.com/v5/search/%ED%83%9C%ED%8F%89%EC%86%8C%EA%B5%AD%EB%B0%A5/place", 36.3419729, 127.4250897, "e.jpg", "s" ));
            list.add(new Marker(104, "오씨칼국수", "https://map.naver.com/v5/search/%EC%98%A4%EC%94%A8%EC%B9%BC%EA%B5%AD%EC%88%98/place", 36.321065, 127.3512581, "e.jpg", "s" ));
            list.add(new Marker(105, "시민칼국수", "https://map.naver.com/v5/search/%EC%8B%9C%EB%AF%BC%EC%B9%BC%EA%B5%AD%EC%88%98/place", 36.321065, 127.415642, "e.jpg", "s" ));

        }else if (loc.equals("j")){
            list.add(new Marker(106, "태평소국밥", "http://www.naver.com", 33.242829, 126.3586304, "e.jpg", "s" ));
            list.add(new Marker(107, "오씨칼국수", "http://www.naver.com", 33.293829, 126.3386304, "e.jpg", "s" ));
            list.add(new Marker(108, "시민칼국수", "http://www.naver.com", 33.247829, 126.3786304, "e.jpg", "s" ));
        }

        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }


}
