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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;

    private String race;

    private String className;

    @Column(columnDefinition="TEXT")
    private String lore;

    private String location;

    private String difficulty;

    @Singular
    @OneToMany(mappedBy = "champions", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Skills> skills;
}
