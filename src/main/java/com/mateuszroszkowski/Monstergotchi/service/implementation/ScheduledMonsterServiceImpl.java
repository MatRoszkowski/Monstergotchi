package com.mateuszroszkowski.Monstergotchi.service.implementation;

import com.mateuszroszkowski.Monstergotchi.model.Monster;
import com.mateuszroszkowski.Monstergotchi.repository.MonsterRepository;
import com.mateuszroszkowski.Monstergotchi.service.MonsterService;
import com.mateuszroszkowski.Monstergotchi.service.ScheduledMonsterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@EnableAsync
@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class ScheduledMonsterServiceImpl implements ScheduledMonsterService {
    private final MonsterRepository monsterRepository;
    private final MonsterService monsterService;
    private int numberOfRecords = 50;
    private int hungerDecrease = 10;
    private int funDecrease = 20;
    private int thirstDecrease = 30;

    @Override
    @Async
    @Scheduled(fixedDelay = 86400000)//delay of 24h for call
    public void hungerDecreaser() {
        try {
            int offset = 0;
            Page<Monster> monsters;
            do {
                monsters = monsterService.getMonstersWithPagination(offset, numberOfRecords);
                for (int i = 0; i < numberOfRecords - 1; i++) {
                    monsters.forEach(monster -> monster.setHunger(monster.getHunger() - hungerDecrease));
                }
                monsterRepository.saveAll(monsters);
                offset++;
            } while (offset < monsters.getTotalPages() - 1);
            log.info("hungerDecreaser method called");
        } catch (RuntimeException re) {
            log.info(re.getMessage());
        }

    }

    @Override
    @Async
    @Scheduled(fixedDelay = 86400000)//delay of 24h for call
    public void funDecreaser() {
        try {
            int offset = 0;
            Page<Monster> monsters;
            do {
                monsters = monsterService.getMonstersWithPagination(offset, numberOfRecords);
                for (int i = 0; i < numberOfRecords - 1; i++) {
                    monsters.forEach(monster -> monster.setHunger(monster.getHunger() - funDecrease));
                }
                monsterRepository.saveAll(monsters);
                offset++;
            } while (offset < monsters.getTotalPages() - 1);
            log.info("funDecreaser method called");
        } catch (RuntimeException re) {
            log.info(re.getMessage());
        }

    }

    @Override
    @Async
    @Scheduled(fixedDelay = 86400000)//delay of 24h for call
    public void thirstDecreaser() {
        try {
            int offset = 0;
            Page<Monster> monsters;
            do {
                monsters = monsterService.getMonstersWithPagination(offset, numberOfRecords);
                for (int i = 0; i < numberOfRecords - 1; i++) {
                    monsters.forEach(monster -> monster.setHunger(monster.getHunger() - thirstDecrease));
                }
                monsterRepository.saveAll(monsters);
                offset++;
            } while (offset < monsters.getTotalPages() - 1);
            log.info("thirstDecreaser method called");
        } catch (RuntimeException re) {
            log.info(re.getMessage());
        }
    }
}
