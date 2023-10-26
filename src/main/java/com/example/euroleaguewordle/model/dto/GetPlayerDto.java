package com.example.euroleaguewordle.model.dto;

import com.example.euroleaguewordle.model.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPlayerDto {

    private Long id;

    private String name;

    private Position position;

    private int height;

    private int jerseyNumber;

    private Long teamId;

    private String nationality;

    private int age;

    private String image;

    private String teamImage;

}
