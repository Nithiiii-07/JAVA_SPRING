package com.Nithish.Jpa;

import com.Nithish.Jpa.model.student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaApplication.class, args);
		student st= context.getBean(student.class);
		student s2= context.getBean(student.class);
		student s3= context.getBean(student.class);
		studentrepo repo=context.getBean(studentrepo.class);
//		st.setRollNo(1);
//		st.setName("Nithish");
//		st.setMarks(25);
//
//		s2.setRollNo(2);
//		s2.setName("Luffy");
//		s2.setMarks(90);
//
//		s3.setRollNo(3);
//		s3.setName("Zoro");
//		s3.setMarks(80);
//
//		repo.save(s2);
//		repo.save(s3);
		System.out.println(repo.findAll());
	}

}
