package com.norbert.assistant.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Champions {
    @Id
    @GeneratedValue
    long ID;

    String name;

    String race;

    String classsName;

    String lore;

    String location;

    String difficulty;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Singular
    List<Skills> skills;
}
