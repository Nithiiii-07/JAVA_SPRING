package com.nithish.DemoProject.Service;

import com.nithish.DemoProject.Model.Laptop;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    public void AddComputer(Laptop lap){
        System.out.println("Added");
    }
    public boolean Check(Laptop lap){
        return true;
    }
}
