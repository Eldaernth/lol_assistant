package com.norbert.assistant.controller;

import com.norbert.assistant.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/{champName}")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public ResponseEntity getItems(@PathVariable("champName")String champName){
        return ResponseEntity.ok(itemRepository.getItemsByChampions_Name(champName));
    }
}
