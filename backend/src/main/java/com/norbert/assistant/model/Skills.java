package com.norbert.assistant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Skills {

    @Id
    @GeneratedValue
    long id;

    String name;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    Champions champions;

}
