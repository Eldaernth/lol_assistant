package com.norbert.assistant.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ItemBuildDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Long buildId;

    public ItemBuildDetail(String name, Long buildId) {
        this.name = name;
        this.buildId = buildId;
    }
}
