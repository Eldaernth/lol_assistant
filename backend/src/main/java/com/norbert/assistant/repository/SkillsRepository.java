package com.norbert.assistant.repository;

import com.norbert.assistant.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository  extends JpaRepository<Skills,Long> {
    List<Skills> getAllByChampions_Name(String name);

}
