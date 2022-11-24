package com.CodingDojo.JavaExam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.JavaExam.models.Team;
import com.CodingDojo.JavaExam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
    Optional<User> findByEmail(String email);
    List<User> findByTeamjoinNotContaining(Team teamjoin);
    
}
