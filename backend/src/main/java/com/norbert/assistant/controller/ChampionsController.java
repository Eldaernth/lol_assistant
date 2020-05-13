package com.norbert.assistant.controller;


import com.norbert.assistant.repository.ChampionsRepository;
import com.norbert.assistant.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ChampionsController {

    @Autowired
    ChampionsRepository championsRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @GetMapping("{name}")
    public ResponseEntity getChampByName(@PathVariable("name") String name){
        return ResponseEntity.ok(championsRepository.getChampionsByName(name));
    }

    @GetMapping("{name}/skills")
    public ResponseEntity getChampSkills(@PathVariable("name") String name){
        return ResponseEntity.ok(skillsRepository.getAllByChampions_Name(name));
    }

}

