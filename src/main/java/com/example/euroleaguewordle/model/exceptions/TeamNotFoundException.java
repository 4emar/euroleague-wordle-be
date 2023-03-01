package com.example.euroleaguewordle.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException (Long teamId) {
        super(String.format("Team with id: %d does not exist.", teamId));
    }

}
