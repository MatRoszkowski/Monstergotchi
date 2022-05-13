package com.mateuszroszkowski.Monstergotchi.repository;

import com.mateuszroszkowski.Monstergotchi.model.Monster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends MongoRepository<Monster, String> {
}
