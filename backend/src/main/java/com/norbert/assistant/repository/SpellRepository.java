package com.norbert.assistant.repository;

import com.norbert.assistant.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<Spell,Long> {
}
