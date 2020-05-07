package com.norbert.assistant;

import com.norbert.assistant.model.Champion;
import com.norbert.assistant.model.Skill;
import com.norbert.assistant.repository.ChampionsRepository;
import com.norbert.assistant.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssistantApplication {
    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    ChampionsRepository championsRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssistantApplication.class, args);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {
            Skill skill1 = Skill.builder()
                    .name("Vastayan Grace")
                    .description("Whenever Ahri's spells hit a champion 2 times within a short period, she briefly " +
                            "gains movement speed.")
                    .icon_name("Vastayan_Grace")
                    .build();

            Skill skill2 = Skill.builder()
                    .name("Orb of Deception")
                    .description("Ahri sends out and pulls back her orb, dealing magic damage on the way out and true " +
                            "damage on the way back. After earning several spell hits, Ahri's next orb hits will restore her health. ")
                    .icon_name("Orb_of_Deception")
                    .build();

            Skill skill3 = Skill.builder()
                    .name("Fox-Fire")
                    .description("Ahri releases three fox-fires, that lock onto and attack nearby enemies.")
                    .icon_name("Fox-Fire")
                    .build();

            Skill skill4 = Skill.builder()
                    .name("Charm")
                    .description("Ahri blows a kiss that damages and charms an enemy it encounters, instantly stopping " +
                            "movement abilities and causing them to walk harmlessly towards her. The target temporarily " +
                            "takes increased damage from Ahri.")
                    .icon_name("Charm")
                    .build();

            Skill skill5 = Skill.builder()
                    .name("Spirit Rush")
                    .description("Ahri dashes forward and fires essence bolts, damaging nearby enemies. Spirit Rush " +
                            "can be cast up to three times before going on cooldown.")
                    .icon_name("Spirit_Rush")
                    .build();

            Champion champ = Champion.builder()
                    .name("Ahri")
                    .title("the Nine-Tailed Fox")
                    .race("Vastaya")
                    .className("Mage")
                    .difficulty("Medium")
                    .location("Ionia")
                    .lore("Innately connected to the latent power of Runeterra, Ahri is a vastaya who can reshape magic" +
                            "into orbs of raw energy. She revels in toying with her prey by manipulating their emotions " +
                            "before devouring their life essence. Despite her predatory nature, Ahri retains a sense of " +
                            "empathy as she receives flashes of memory from each soul she consumes.")
                    .skill(skill1)
                    .skill(skill2)
                    .skill(skill3)
                    .skill(skill4)
                    .skill(skill5)
                    .build();

            championsRepository.save(champ);
            skill1.setChampions(champ);
            skill2.setChampions(champ);
            skill3.setChampions(champ);
            skill4.setChampions(champ);
            skill5.setChampions(champ);
            skillsRepository.save(skill1);
            skillsRepository.save(skill2);
            skillsRepository.save(skill3);
            skillsRepository.save(skill4);
            skillsRepository.save(skill5);
        };
    }
}

