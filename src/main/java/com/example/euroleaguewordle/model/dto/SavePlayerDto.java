package com.example.euroleaguewordle.model.dto;

import com.example.euroleaguewordle.model.enums.Position;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePlayerDto implements Serializable {

    private String name;

    private int age;

    private Position position;

    private int height;

    private int jerseyNumber;

    private Long teamId;

    private String nationality;

    private String image;
}
