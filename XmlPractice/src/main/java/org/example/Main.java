package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        Desktop obj= context.getBean( Desktop.class);
//        obj.compile();
        Alien obj=context.getBean(Alien.class);
        obj.Code();

//        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj= (Alien) context.getBean("alien");
//        obj.Code();
    }
}