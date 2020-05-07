package com.norbert.assistant.repository;

import com.norbert.assistant.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository  extends JpaRepository<Skill,Long> {
    List<Skill> getAllByChampions_Name(String name);

}
