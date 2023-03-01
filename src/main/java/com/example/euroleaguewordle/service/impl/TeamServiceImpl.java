package com.example.euroleaguewordle.service.impl;

import com.example.euroleaguewordle.model.Team;
import com.example.euroleaguewordle.model.dto.SaveTeamDto;
import com.example.euroleaguewordle.model.exceptions.TeamNotFoundException;
import com.example.euroleaguewordle.repository.TeamRepository;
import com.example.euroleaguewordle.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public Team add(SaveTeamDto saveTeamDto) {
        Team team = new Team();
        team.setName(saveTeamDto.getName());
        team.setImage(saveTeamDto.getImage());

        this.teamRepository.save(team);

        return team;
    }

    @Override
    public String findImageById(Long id) {
        Team team = this.teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));

        return team.getImage();
    }
}
