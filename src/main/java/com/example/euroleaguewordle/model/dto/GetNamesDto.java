package com.example.euroleaguewordle.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetNamesDto implements Serializable {

    private String label;
    private Long value;

}
