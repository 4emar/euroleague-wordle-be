package com.example.euroleaguewordle.service;

import com.example.euroleaguewordle.model.Team;
import com.example.euroleaguewordle.model.dto.SaveTeamDto;

public interface TeamService {

    Team add (SaveTeamDto saveTeamDto);

    String findImageById (Long id);

}
