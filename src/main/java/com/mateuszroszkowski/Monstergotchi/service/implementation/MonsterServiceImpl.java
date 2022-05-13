package com.mateuszroszkowski.Monstergotchi.service.implementation;

import com.mateuszroszkowski.Monstergotchi.dto.MonsterDto;
import com.mateuszroszkowski.Monstergotchi.mapper.MonsterMapper;
import com.mateuszroszkowski.Monstergotchi.model.Monster;
import com.mateuszroszkowski.Monstergotchi.model.User;
import com.mateuszroszkowski.Monstergotchi.repository.MonsterRepository;
import com.mateuszroszkowski.Monstergotchi.repository.UserRepository;
import com.mateuszroszkowski.Monstergotchi.service.MonsterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@AllArgsConstructor
public class MonsterServiceImpl implements MonsterService {
    private final MonsterRepository monsterRepository;
    private final UserRepository userRepository;
    private final MonsterMapper monsterMapper;

    @Override
    public void createMonster(MonsterDto monsterDto, User user) {
        Monster monster = Monster.builder()
                .name(monsterDto.getName())
                .healthBar(100)
                .hunger(100)
                .fun(100)
                .thirst(100).build();
        Monster monsterWithId = monsterRepository.insert(monster);
        user.getMonsters().add(monsterWithId);
        userRepository.save(user);
        log.info("Monster saved successfully");
    }
    @Override
    public Page<Monster> getMonstersWithPagination(int offset, int numberOfRecords) {
        Page<Monster> monsters = monsterRepository.findAll(PageRequest.of(offset, numberOfRecords));
        return monsters;
    }

    @Override
    public void feedMonster(String id) {
        try {
            Monster monster = monsterRepository.findById(id).get();
            int hunger = monster.getHunger();
            if (hunger >= 90) {
                monster.setHunger(100);
            } else {
                monster.setHunger(monster.getHunger() + 10);
            }
            monsterRepository.save(monster);
            log.info("feeding successful");
        } catch (Exception e) {
            log.info("feeding not successful");
        }
    }

    @Override
    public void playWithMonster(String id) {
        try {
            Monster monster = monsterRepository.findById(id).get();
            int fun = monster.getFun();
            if (fun >= 90) {
                monster.setFun(100);
            } else {
                monster.setFun(monster.getFun() + 10);
            }
            monsterRepository.save(monster);
            log.info("playing successful");
        } catch (Exception e) {
            log.info("playing not successful");
        }
    }

    @Override
    public void waterMonster(String id) {
        try {
            Monster monster = monsterRepository.findById(id).get();
            int thirst = monster.getThirst();
            if (thirst >= 90) {
                monster.setThirst(100);
            } else {
                monster.setThirst(monster.getThirst() + 10);
            }
            monsterRepository.save(monster);
            log.info("watering successful");
        } catch (Exception e) {
            log.info("watering not successful");
        }
    }
}
