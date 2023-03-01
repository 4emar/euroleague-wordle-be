package com.example.euroleaguewordle.model.dto;

import com.example.euroleaguewordle.model.enums.Answer;
import com.example.euroleaguewordle.model.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {

    private Answer name;

    private Answer teamId;

    private Answer position;

    private Answer nationality;

    private Answer height;

    private Answer jerseyNumber;

    private Answer age;

}
