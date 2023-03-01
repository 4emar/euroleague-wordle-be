package com.example.euroleaguewordle.repository;

import com.example.euroleaguewordle.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
