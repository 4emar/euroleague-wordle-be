package com.example.euroleaguewordle.web;

import com.example.euroleaguewordle.model.Player;
import com.example.euroleaguewordle.model.dto.AnswerDto;
import com.example.euroleaguewordle.model.dto.GetNamesDto;
import com.example.euroleaguewordle.model.dto.GetPlayerDto;
import com.example.euroleaguewordle.model.dto.SavePlayerDto;
import com.example.euroleaguewordle.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.example.euroleaguewordle.EuroleagueWordleApplication.randomNum;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/player", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/user/compare/{id}")
    public AnswerDto comparePlayers (@PathVariable Long id) {
        return this.playerService.comparePlayers(id);
    }

    @GetMapping("/user/getWordle")
    public int getWordle () {
        return randomNum;
    }

    @GetMapping("/user/{name}")
    public Player getPlayerByName (@PathVariable String name) {
        return this.playerService.findByName(name);
    }

    @PostMapping("/user/addPlayer")
    public Player addPlayer(@RequestBody SavePlayerDto savePlayerDto, @RequestHeader("Authorization") String apiKey) {
        String secretKey = "mojot_taen_kljuc";
        if (apiKey != null && apiKey.equals("Bearer " + secretKey)) {
            return this.playerService.add(savePlayerDto);
        } else {
            // Handle unauthorized access here, such as returning an error or throwing an exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unauthorized access");
        }
    }

    @GetMapping("/user/allPlayers")
    public List<Player> getAllPlayers () {
        return this.playerService.findAll();
    }

    @GetMapping("/user/allNames")
    public List<GetNamesDto> getAllNames() {
        return this.playerService.findAllNames();
    }

    @GetMapping("/user/getGuessed/{id}")
    public GetPlayerDto getGuessedPlayer (@PathVariable Long id) {
        return this.playerService.getGuessedPlayer(id);
        //return this.playerService.findById(id);
    }

    @GetMapping("/user/getWordlePlayer")
    public Player getWordlePlayer () {
        return this.playerService.getWordlePlayer();
    }

}