package com.norbert.assistant.repository;

import com.norbert.assistant.model.Trinket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrinketRepository extends JpaRepository<Trinket,Long> {
}
