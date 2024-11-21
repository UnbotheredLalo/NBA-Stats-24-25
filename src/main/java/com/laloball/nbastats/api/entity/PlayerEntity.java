package com.laloball.nbastats.api.entity;

import com.laloball.nbastats.api.domain.BasketballPosition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private BasketballPosition position;


    @Column(nullable = false)
    private Integer numberOfPick;

    @Column(nullable = false)
    private Integer numberOfSeasons;


    public PlayerEntity(String name, int number, String country, BasketballPosition position,
                  int numberOfPick, int numberOfSeasons) {
        this.name = name;
        this.number = number;
        this.country = country;
        this.position = position;
        this.numberOfPick = numberOfPick;
        this.numberOfSeasons = numberOfSeasons;
    }

}
