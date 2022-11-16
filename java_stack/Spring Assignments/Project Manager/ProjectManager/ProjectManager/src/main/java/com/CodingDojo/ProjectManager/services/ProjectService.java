package com.CodingDojo.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingDojo.ProjectManager.models.Project;
import com.CodingDojo.ProjectManager.models.User;
import com.CodingDojo.ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
    private ProjectRepository projectRepo;
	
	public ProjectService (ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProjects = projectRepo.findById(id);
		if (optionalProjects.isPresent()) {
			return optionalProjects.get();
		} else {
			return null;
		}
	}
	
	public Project updateProject(Project project) {
		Optional<Project> oproject = projectRepo.findById(project.getId());
		Project a = oproject.get();
		a = project;
		projectRepo.save(a);
		return projectRepo.save(project);
	}
	
	public void deleteProject(Long id) {
		Optional<Project> optionalProjects = projectRepo.findById(id);
		if (optionalProjects.isPresent()) {
			projectRepo.deleteById(id);
		}
	}
//	public List <Project> notjoin(){
//		return projectRepo.findByuserjoin(null);
//	}
//	
//	public List <Project> joined(User user){
//		return projectRepo.findByuserjoin(user);
//	}
	public List<Project> getProjectsfor(User userjoin){
    	return projectRepo.findByUserjoinContaining(userjoin);
    }
    
    public List<Project> getProjectsNotfor(User userjoin){
    	return projectRepo.findByUserjoinNotContaining(userjoin);
    }
	
}
