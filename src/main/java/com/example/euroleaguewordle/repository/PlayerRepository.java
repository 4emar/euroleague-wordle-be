package com.example.euroleaguewordle.repository;

import com.example.euroleaguewordle.model.Player;
import com.example.euroleaguewordle.model.enums.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player getPlayerByName (String name);

}
