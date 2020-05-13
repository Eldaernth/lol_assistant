package com.norbert.assistant;

import com.norbert.assistant.model.Champion;
import com.norbert.assistant.model.Item;
import com.norbert.assistant.model.Skill;
import com.norbert.assistant.repository.ChampionsRepository;
import com.norbert.assistant.repository.ItemRepository;
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

    @Autowired
    ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssistantApplication.class, args);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {
            Item item = Item.builder()
                    .name("Sorcerer's Shoes")
                    .description(
                            "For nearly a century, the greatest Mage icon mage in Valoran resided in the scorched desert of the Zear realm until the first crusade of the Rune Wars devastated the entire region forcing millions to flee. The crusaders killed all desperate travelers attempting the mass exodus from Zear, but one mage escaped their grasp by making such haste across the land that word spread throughout Valoran that the very shoes this mage wore must be imbued with immense power")
                    .icon_name("Sorcerer's_Shoes")
                    .price(1100)
                    .build();

            Item item2 = Item.builder()
                    .name("Morellonomicon")
                    .description(
                            "\n" +
                                    "Stats\n" +
                                    "+70 ability power\n" +
                                    "+300 health\n" +
                                    "Passive\n" +
                                    "Unique – Touch of Death: +15 magic penetration.\n" +
                                    "Unique – Cursed Strike: Dealing magic damage to an enemy champion inflicts them with Grievous Wounds icon Grievous Wounds for 3 seconds.\n")
                    .icon_name("Morellonomicon")
                    .price(3000)
                    .build();

            Item item3 = Item.builder()
                    .name("Rabadon's Deathcap")
                    .description(
                    "\n" +
                            "Stats\n" +
                            "+120 ability power\n" +
                            "Passive\n" +
                            "Unique: +40% ability power.\n")
                            .icon_name("Rabadon's_Deathcap")
                    .price(3600)
                    .build();

            Item item4 = Item.builder()
                    .name("Zhonya's Hourglass")
                    .description(
                    "\n" +
                            "Stats\n" +
                            "+75 ability power\n" +
                            "+45 armor\n" +
                            "+10% cooldown reduction\n" +
                            "Active\n" +
                            "Unique – Stasis: Put yourself in Stasis icon stasis for 2.5 seconds, rendering yourself Playful untargetable and Cosmic Radiance invulnerable for the duration but becoming unable to move, declare basic attacks, cast abilities or item actives, or use any summoner spells during this time (120 second cooldown).\n")
                    .icon_name("Zhonya's_Hourglass")
                    .price(2900)
                    .build();

            Item item5 = Item.builder()
                    .name("Hextech GLP-800")
                    .description(
                            "\n" +
                                    "Stats\n" +
                                    "+80 ability power\n" +
                                    "+10% cooldown reduction\n" +
                                    "+600 mana\n" +
                                    "Passive\n" +
                                    "Unique – Haste: Grants an additional 10% cooldown reduction.\n" +
                                    "Active\n" +
                                    "Unique – Frost Bolt: After a 0.25-second delay, fires over 0.2 seconds a spray of five icy bolts in a cone, which each bolt dealing 100 − 200 (based on level) (+ 20% AP) magic damage and Slow icon slowing by 65%, decaying over 2 second, the first units hit (40 second cooldown, shared with other Hextech items).\n")
                    .icon_name("Hextech_GLP-800")
                    .price(1100)
                    .build();

            Item item6 = Item.builder()
                    .name("Doran's Ring")
                    .description(
                            "\n" +
                                    "Stats\n" +
                                    "+15 ability power\n" +
                                    "+60 health\n" +
                                    "+5 mana per 5 seconds\n" +
                                    "Passive\n" +
                                    "Basic attacks deal an additional 5 physical damage to minions on-hit.\n")
                    .icon_name("Doran's_Ring")
                    .price(400)
                    .build();

            Item item7 = Item.builder()
                    .name("Health Potion")
                    .description(
                            "\n" +
                                    "Consume\n" +
                                    "Regenerates 5 health every half-second for 15 seconds, restoring a total of 150 health.\n" +
                                    "Limitations\n" +
                                    "Limited to 5 at one time. Limited to one type of Healing Potion.\n")
                    .icon_name("Health_Potion")
                    .price(1100)
                    .build();

            Item item8 = Item.builder()
                    .name("Hextech Protobelt-01")
                    .description(
                            "\n" +
                                    "Stats\n" +
                                    "+60 ability power\n" +
                                    "+10% cooldown reduction\n" +
                                    "+300 health\n" +
                                    "Active\n" +
                                    "Unique – Fire Bolt: Dash Dash forward dealing 75 − 150 (based on level) (+ 25% AP) magic damage on your way and behind you, after which you fire a nova of seven fire bolts in a cone, with each bolt dealing the same magic damage. Against Champion icon champions and Monster icon monsters, each instance of damage beyond the first deals 90% reduced damage (40 second cooldown, shared with other Hextech items).\n" +
                                    "\n" +
                                    "Fire Bolt resets the user's basic attack timer.\n" +
                                    "Limitations\n" +
                                    "This dash cannot pass through terrain.\n")
                    .icon_name("Hextech_Protobelt-01")
                    .price(1100)
                    .build();

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
                    .item(item)
                    .item(item2)
                    .item(item3)
                    .item(item4)
                    .item(item5)
                    .item(item6)
                    .item(item7)
                    .item(item8)
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
            item.setChampions(champ);
            item2.setChampions(champ);
            item3.setChampions(champ);
            item4.setChampions(champ);
            item5.setChampions(champ);
            item6.setChampions(champ);
            item7.setChampions(champ);
            item8.setChampions(champ);
            itemRepository.save(item);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
            itemRepository.save(item5);
            itemRepository.save(item6);
            itemRepository.save(item7);
            itemRepository.save(item8);
        };
    }
}

