package com.nithish.DemoProject.Model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
//    public Laptop() {
//        System.out.println("laptop Class Created");
//    }

    public void compile(){
        System.out.println("Laptop is Compiling");
    }
}
