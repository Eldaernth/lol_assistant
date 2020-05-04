package com.norbert.assistant.controller;


import com.norbert.assistant.model.Champions;
import com.norbert.assistant.repository.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChampionsController {

    @Autowired
    ChampionsRepository championsRepository;

    @GetMapping("{name}")
    public ResponseEntity getChampByName(@PathVariable("name") String name){
        return ResponseEntity.ok(championsRepository.getChampionsByName(name));
    }
}
