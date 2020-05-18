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
public class ItemBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Singular
    @ManyToMany(mappedBy = "itemBuild", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Champion champions;
}
