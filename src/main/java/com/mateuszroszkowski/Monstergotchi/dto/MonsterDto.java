package com.mateuszroszkowski.Monstergotchi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonsterDto {
    private String id;
    private String name;
    private int healthBar;
    private int hunger;
    private int fun;
    private int thirst;
}
