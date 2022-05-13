package com.mateuszroszkowski.Monstergotchi.mapper;

import com.mateuszroszkowski.Monstergotchi.dto.MonsterDto;
import com.mateuszroszkowski.Monstergotchi.model.Monster;

public class MonsterMapper {
    public Monster map(MonsterDto monsterDto) {
        return Monster.builder()
                .name(monsterDto.getName())
                .healthBar(monsterDto.getHealthBar())
                .hunger(monsterDto.getHealthBar())
                .fun(monsterDto.getFun())
                .thirst(monsterDto.getThirst()).build();
    }

    public MonsterDto map(Monster monster) {
        return MonsterDto.builder()
                .id(monster.getId())
                .name(monster.getName())
                .healthBar(monster.getHealthBar())
                .hunger(monster.getHealthBar())
                .fun(monster.getFun())
                .thirst(monster.getThirst()).build();
    }
}
