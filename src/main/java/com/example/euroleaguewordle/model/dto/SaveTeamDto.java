package com.example.euroleaguewordle.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTeamDto implements Serializable {

    private String name;

    private String image;

}
