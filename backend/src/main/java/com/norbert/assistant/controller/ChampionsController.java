package com.norbert.assistant.controller;


import com.norbert.assistant.model.Champions;
import com.norbert.assistant.repository.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ChampionsController {

    @Autowired
    ChampionsRepository championsRepository;

    @GetMapping("{name}")
    public ResponseEntity getChampByName(@PathVariable("name") String name){
        System.out.println(championsRepository.getChampionsByName(name));
        return ResponseEntity.ok(championsRepository.getChampionsByName(name));
    }
}
