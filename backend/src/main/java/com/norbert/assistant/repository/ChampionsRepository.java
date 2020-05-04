package com.norbert.assistant.repository;

import com.norbert.assistant.model.Champions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepository extends JpaRepository<Champions,Long> {
        Champions getChampionsByName(String name);
}
