package com.norbert.assistant.repository;

import com.norbert.assistant.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository  extends JpaRepository<Skills,Long> {
}
