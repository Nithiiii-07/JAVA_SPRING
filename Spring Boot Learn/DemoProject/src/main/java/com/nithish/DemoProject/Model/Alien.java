package com.nithish.DemoProject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Computer com;
    @Value("24")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public  void Job(){
        com.compile();
        System.out.println("Alien Component is Coding Java Spring Boot");
    }
}
