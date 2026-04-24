package com.nithish.DemoProject;

import com.nithish.DemoProject.Model.Alien;
import com.nithish.DemoProject.Model.Laptop;
import com.nithish.DemoProject.Repo.LaptopRepo;
import com.nithish.DemoProject.Service.ComputerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DemoProjectApplication.class, args);
		ComputerService service=context.getBean(ComputerService.class);
		Alien obj=context.getBean(Alien.class);
		Laptop lap=context.getBean(Laptop.class);
		service.AddComputer(lap);
		LaptopRepo repo=context.getBean(LaptopRepo.class);
		repo.save(lap);
//		System.out.println(obj.getAge());
//		obj.Job();
	}
}
