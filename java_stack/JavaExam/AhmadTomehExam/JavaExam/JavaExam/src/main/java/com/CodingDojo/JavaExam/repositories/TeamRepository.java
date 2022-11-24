package com.CodingDojo.JavaExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.JavaExam.models.Team;
import com.CodingDojo.JavaExam.models.User;

public interface TeamRepository extends CrudRepository<Team, Long> {
    
    List<Team> findAll();
//    List<Project> findByuserjoin(User user);
    
    List<Team> findByUserjoinNotContaining(User userjoin);
    List<Team> findByUserjoinContaining(User userjoin);
}
