package com.mateuszroszkowski.Monstergotchi.service;

import com.mateuszroszkowski.Monstergotchi.dto.MonsterDto;
import com.mateuszroszkowski.Monstergotchi.model.Monster;
import com.mateuszroszkowski.Monstergotchi.model.User;
import org.springframework.data.domain.Page;

public interface MonsterService {
    void createMonster(MonsterDto MonsterDto, User user);
    Page<Monster> getMonstersWithPagination(int offset, int numberOfRecords);
    void feedMonster(String id);
    void playWithMonster(String id);
    void waterMonster(String id);
}
