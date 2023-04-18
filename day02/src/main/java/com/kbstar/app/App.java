package com.kbstar.app;

import com.kbstar.frame.TV;
import com.kbstar.tv.STV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        //TV tv1 = new STV(); 원래 쓰던 방법
        //아래는 위의 방법을 스프링을 사용한 역주입으로 바꾼 것
        //getBean(DL: Look Up 중  무엇을? s(String)을  스트링의 값은? "ltv"
        TV tv =
                (TV) factory.getBean("ltv");
        tv.turnOn();
    }

}


