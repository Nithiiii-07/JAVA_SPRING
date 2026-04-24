package com.nithish.DemoProject.Repo;

import com.nithish.DemoProject.Model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepo {
    public void save(Laptop lap){
        System.out.println("Saved");
        lap.compile();
    }
}
