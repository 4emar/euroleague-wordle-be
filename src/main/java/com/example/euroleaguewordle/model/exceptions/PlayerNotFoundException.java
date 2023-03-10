package com.example.euroleaguewordle.model.exceptions;

import com.example.euroleaguewordle.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(Long id) {
        super(String.format("Player with id: %d does not exist.", id));
    }

}
