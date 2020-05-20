package com.norbert.assistant.controller;

import com.norbert.assistant.model.Item;
import com.norbert.assistant.model.ItemBuild;
import com.norbert.assistant.repository.ItemBuildRepository;
import com.norbert.assistant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class ItemController {

    List<List<Item>> items = new ArrayList<>();

    List<String> names = new ArrayList<>();

    @Autowired
    ItemBuildRepository itemBuildRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/{champName}/item_builds")
    public ResponseEntity getItemBuilds(@PathVariable("champName")String champName){
        items.clear();
        names.clear();
        List<ItemBuild> itemBuilds = itemBuildRepository.getItemBuildByChampions_Name(champName);
        for(ItemBuild itemBuild : itemBuilds){
            items.add(itemBuild.getItems());
            names.add(itemBuild.getName());
        }
        return ResponseEntity.ok(new ArrayList<>(Arrays.asList(names,items)));
    }

    @GetMapping("/items")
    public ResponseEntity getItems(){
        System.out.println(itemRepository.findAll());
        return ResponseEntity.ok(itemRepository.findAll());
    }
}
