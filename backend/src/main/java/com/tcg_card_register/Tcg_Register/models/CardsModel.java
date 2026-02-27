package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cards")
public class CardsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int type;
    private String firstmove;
    private String secondmove;
    private String ability;
    private int weakness;
    private int resistance;
    private int retreat;
    private int illustrator;
    private String image;
    private int rarity;
    private int status;
    private int setNumber;
    private UUID setExpansion;

    @Autowired
    public CardsModel() {
    }

    public CardsModel(UUID setExpansion, int setNumber, int status, int rarity, String image, int illustrator, int retreat, int resistance, int weakness, String ability, String secondmove, String firstmove, int type, String name, long id) {
        this.setExpansion = setExpansion;
        this.setNumber = setNumber;
        this.status = status;
        this.rarity = rarity;
        this.image = image;
        this.illustrator = illustrator;
        this.retreat = retreat;
        this.resistance = resistance;
        this.weakness = weakness;
        this.ability = ability;
        this.secondmove = secondmove;
        this.firstmove = firstmove;
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public int getSetNumber() {
        return setNumber;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getFirstmove() {
        return firstmove;
    }

    public String getSecondmove() {
        return secondmove;
    }

    public String getAbility() {
        return ability;
    }

    public int getWeakness() {
        return weakness;
    }

    public int getResistance() {
        return resistance;
    }

    public int getRetreat() {
        return retreat;
    }

    public int getIllustrator() {
        return illustrator;
    }

    public String getImage() {
        return image;
    }

    public int getRarity() {
        return rarity;
    }

    public int getStatus() {
        return status;
    }

    public UUID getSetExpansion() {
        return setExpansion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFirstmove(String firstmove) {
        this.firstmove = firstmove;
    }

    public void setSecondmove(String secondmove) {
        this.secondmove = secondmove;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setWeakness(int weakness) {
        this.weakness = weakness;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setRetreat(int retreat) {
        this.retreat = retreat;
    }

    public void setIllustrator(int illustrator) {
        this.illustrator = illustrator;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSetExpansion(UUID setExpansion) {
        this.setExpansion = setExpansion;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }
}
