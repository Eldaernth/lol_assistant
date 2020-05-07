package com.norbert.assistant.repository;

import com.norbert.assistant.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepository extends JpaRepository<Champion,Long> {
        Champion getChampionsByName(String name);
}
