package com.CodingDojo.JavaExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingDojo.JavaExam.models.Team;
import com.CodingDojo.JavaExam.models.User;
import com.CodingDojo.JavaExam.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
    private TeamRepository teamRepo;
	
	public TeamService (TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	public List<Team> allTeams(){
		return teamRepo.findAll();
	}
	
	public Team createTeam(Team team) {
		return teamRepo.save(team);
	}
	
	public Team findTeam(Long id) {
		Optional<Team> optionalTeams = teamRepo.findById(id);
		if (optionalTeams.isPresent()) {
			return optionalTeams.get();
		} else {
			return null;
		}
	}
	
	public Team updateTeam(Team team) {
		Optional<Team> oteam = teamRepo.findById(team.getId());
		Team a = oteam.get();
		a = team;
		teamRepo.save(a);
		return teamRepo.save(team);
	}
	
	public void deleteTeam(Long id) {
		Optional<Team> optionalTeams = teamRepo.findById(id);
		if (optionalTeams.isPresent()) {
			teamRepo.deleteById(id);
		}
	}
//	public List <Team> notjoin(){
//		return teamRepo.findByuserjoin(null);
//	}
//	
//	public List <Team> joined(User user){
//		return teamRepo.findByuserjoin(user);
//	}
	public List<Team> getTeamsfor(User userjoin){
    	return teamRepo.findByUserjoinContaining(userjoin);
    }
    
    public List<Team> getTeamsNotfor(User userjoin){
    	return teamRepo.findByUserjoinNotContaining(userjoin);
    }
	
}
