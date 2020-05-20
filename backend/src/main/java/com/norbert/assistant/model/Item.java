package com.norbert.assistant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    private String icon_name;

    private int price;

    private boolean picked;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    @Singular("itemBuild")
    @JsonIgnore
    private List<ItemBuild> itemBuild;
}
