package com.Nithish.Jpa;

import com.Nithish.Jpa.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentrepo extends JpaRepository<student,Integer> {

}
