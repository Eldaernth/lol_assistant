package com.norbert.assistant;

import com.norbert.assistant.model.Champions;
import org.hibernate.mapping.Collection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class AssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssistantApplication.class, args);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {

            Champions champ = Champions.builder()
                    .name("Ahri")
                    .race("Vastaya")
                    .classsName("Mage")
                    .difficulty("Medium")
                    .location("Ionia")
                    .lore("Innately connected to the latent power of Runeterra, Ahri is a vastaya who can reshape magic" +
                            "into orbs of raw energy. She revels in toying with her prey by manipulating their emotions " +
                            "before devouring their life essence. Despite her predatory nature, Ahri retains a sense of " +
                            "empathy as she receives flashes of memory from each soul she consumes.")
                    .skills(new ArrayList<>(Arrays.asList("Vastayan Grace","Orb of Deception","Fox-Fire","Charm","Spirit Rush")))
                    .build();
        };
    }
}

