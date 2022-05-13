package com.mateuszroszkowski.Monstergotchi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "monsters")
@Builder
public class Monster {

    @Id
    private String id;
    private String name;
    private int healthBar;
    private int hunger;
    private int fun;
    private int thirst;
}
