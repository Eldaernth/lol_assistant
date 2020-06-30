package com.norbert.assistant.controller;

import com.norbert.assistant.model.Champion;
import com.norbert.assistant.model.Item;
import com.norbert.assistant.model.ItemBuild;
import com.norbert.assistant.repository.ChampionsRepository;
import com.norbert.assistant.repository.ItemBuildRepository;
import com.norbert.assistant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
public class ItemController {

    List<List<Item>> items = new ArrayList<>();

    List<String> names = new ArrayList<>();

    List<ItemBuild> itemBuilds = new ArrayList<>();

    @Autowired
    ChampionsRepository championsRepository;

    @Autowired
    ItemBuildRepository itemBuildRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/{champName}/item_builds")
    public ResponseEntity getItemBuilds(@PathVariable("champName") String champName) {
        items.clear();
        names.clear();
        List<ItemBuild> itemBuilds = itemBuildRepository.getItemBuildByChampions_Name(champName);
        for (ItemBuild itemBuild : itemBuilds) {
            items.add(itemBuild.getItems());
            names.add(itemBuild.getName());
        }
        return ResponseEntity.ok(new ArrayList<>(Arrays.asList(names, items)));
    }

    @GetMapping("/items")
    public ResponseEntity getItems() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @PostMapping("/{champName}/item_builds")
    public ResponseEntity<String> addBuild(@PathVariable("champName") String champName,@RequestBody ItemBuild itemBuild) {
        Champion champion = championsRepository.getChampionsByName(champName);

        Item item1 = itemRepository.findById(itemBuild.getItems().get(0).getId()).get();
        Item item2 = itemRepository.findById(itemBuild.getItems().get(1).getId()).get();
        Item item3 = itemRepository.findById(itemBuild.getItems().get(2).getId()).get();
        Item item4 = itemRepository.findById(itemBuild.getItems().get(3).getId()).get();
        Item item5 = itemRepository.findById(itemBuild.getItems().get(4).getId()).get();
        Item item6 = itemRepository.findById(itemBuild.getItems().get(5).getId()).get();

        ItemBuild itemBuild1 = ItemBuild.builder()
                .name(itemBuild.getName())
                .item(item1)
                .item(item2)
                .item(item3)
                .item(item4)
                .item(item5)
                .item(item6)
                .champions(champion)
                .build();

        item1.getItemBuilds().add(itemBuild1);
        item2.getItemBuilds().add(itemBuild1);
        item3.getItemBuilds().add(itemBuild1);
        item4.getItemBuilds().add(itemBuild1);
        item5.getItemBuilds().add(itemBuild1);
        item6.getItemBuilds().add(itemBuild1);
        itemBuildRepository.save(itemBuild1);
        return new ResponseEntity<>("Succesfull", HttpStatus.OK);
    }

    @DeleteMapping("/item_builds/delete/{name}")
    public ResponseEntity<String> deleteBuild(@PathVariable("name") String name){
        ItemBuild itemBuild = itemBuildRepository.getByName(name);
        Iterator<ItemBuild> it;
        for(Item item : itemBuild.getItems()){
            it=item.getItemBuilds().listIterator();
            while (it.hasNext()){
                if(it.next().getId() == itemBuild.getId()){
                    it.remove();
                }
            }
        }
        itemBuildRepository.deleteById(itemBuild.getId());
        return new ResponseEntity<>("Item Build deleted",HttpStatus.OK);
    }
}
