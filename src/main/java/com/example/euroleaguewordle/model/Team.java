package com.example.euroleaguewordle.model;

import com.example.euroleaguewordle.model.baseClass.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "teams")
public class Team extends BaseEntity<Long> implements Serializable {

    @Column(name = "team_name")
    public String name;

    @Column(name = "team_image")
    public String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(image, team.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, image);
    }
}
