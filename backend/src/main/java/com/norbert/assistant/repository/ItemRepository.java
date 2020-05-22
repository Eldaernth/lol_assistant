package com.norbert.assistant.repository;

import com.norbert.assistant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> getItemsByItemBuilds(long itemBuildId);
}
