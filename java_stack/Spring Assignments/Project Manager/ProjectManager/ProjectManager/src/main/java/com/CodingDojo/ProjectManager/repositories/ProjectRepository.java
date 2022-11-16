package com.CodingDojo.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.ProjectManager.models.Project;
import com.CodingDojo.ProjectManager.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    List<Project> findAll();
//    List<Project> findByuserjoin(User user);
    
    List<Project> findByUserjoinNotContaining(User userjoin);
    List<Project> findByUserjoinContaining(User userjoin);
}
