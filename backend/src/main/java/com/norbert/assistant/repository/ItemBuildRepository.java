package com.norbert.assistant.repository;

import com.norbert.assistant.model.Item;
import com.norbert.assistant.model.ItemBuild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemBuildRepository extends JpaRepository<ItemBuild,Long> {

    List<ItemBuild> getItemBuildByChampions_Name(String name);
}
