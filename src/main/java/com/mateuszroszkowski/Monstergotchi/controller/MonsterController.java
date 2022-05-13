package com.mateuszroszkowski.Monstergotchi.controller;

import com.mateuszroszkowski.Monstergotchi.dto.MonsterDto;
import com.mateuszroszkowski.Monstergotchi.model.Monster;
import com.mateuszroszkowski.Monstergotchi.model.User;
import com.mateuszroszkowski.Monstergotchi.service.MonsterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monsters")
@AllArgsConstructor
@Slf4j
public class MonsterController {
    private final MonsterService monsterService;

    @PostMapping("/save")
    public void create(@RequestBody MonsterDto monsterDto, @AuthenticationPrincipal User user) {
        try {
            monsterService.createMonster(monsterDto, user);
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
    }

    @PostMapping("/feed")
    public void feedMonster(@RequestParam String id) {
        monsterService.feedMonster(id);
    }

    @PostMapping("/play")
    public void playWithMonster(@RequestParam String id) {
        monsterService.playWithMonster(id);
    }

    @PostMapping("/water")
    public void waterMonster(@RequestParam String id) {
        monsterService.waterMonster(id);
    }
}
