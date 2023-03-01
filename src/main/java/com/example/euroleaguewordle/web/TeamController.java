package com.example.euroleaguewordle.web;

import com.example.euroleaguewordle.model.Team;
import com.example.euroleaguewordle.model.dto.SaveTeamDto;
import com.example.euroleaguewordle.service.TeamService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/team", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/user/addTeam")
    public Team addTeam (@RequestBody SaveTeamDto saveTeamDto) {
        return this.teamService.add(saveTeamDto);
    }

}
