package com.example.euroleaguewordle.model;

import com.example.euroleaguewordle.model.baseClass.BaseEntity;
import com.example.euroleaguewordle.model.enums.Position;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "players")
public class Player extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private Position position;

    @Column(name = "height")
    private int height;

    @Column(name = "jersey_number")
    private int jerseyNumber;

    @Column(name = "team")
    private Long teamId;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "age")
    private int age;

    @Column(name = "image")
    private String image;

    @Column(name = "team_image")
    private String teamImage;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return height == player.height && jerseyNumber == player.jerseyNumber && age == player.age && Objects.equals(name, player.name) && position == player.position && Objects.equals(teamId, player.teamId) && Objects.equals(nationality, player.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, position, height, jerseyNumber, teamId, nationality, age);
    }
}
