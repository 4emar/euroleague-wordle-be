package com.example.euroleaguewordle.service;

import com.example.euroleaguewordle.model.Player;
import com.example.euroleaguewordle.model.dto.AnswerDto;
import com.example.euroleaguewordle.model.dto.GetNamesDto;
import com.example.euroleaguewordle.model.dto.GetPlayerDto;
import com.example.euroleaguewordle.model.dto.SavePlayerDto;

import java.util.List;

public interface PlayerService {

    Player findById (Long playerId);

    List<Player> findAll();

    Player add (SavePlayerDto savePlayerDto);

    AnswerDto comparePlayers (Long playerId);

    Player findByName (String name);

    List<GetNamesDto> findAllNames();

    Player getWordlePlayer();

    GetPlayerDto getGuessedPlayer(Long playerId);

}
