package com.norbert.assistant.repository;

import com.norbert.assistant.model.Champions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionsRepository extends JpaRepository<Champions,Long> {

}
