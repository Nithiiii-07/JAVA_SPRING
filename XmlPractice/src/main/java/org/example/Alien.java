package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int age;
    @Autowired
    Computer com;
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

    public Alien() {
        System.out.println("Alien Object is Created");
    }

    public void Code(){
        com.compile();
        System.out.println("Alien is Coding");
    }
}
