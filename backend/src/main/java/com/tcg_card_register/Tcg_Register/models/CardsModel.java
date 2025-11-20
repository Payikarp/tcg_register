package com.tcg_card_register.Tcg_Register.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "cards")
public class CardsModel {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int type;
    private String firstmove;
    private String secondmove;
    private String ability;
    private int weakness;
    private int resistance;
    private int retreat;
    private String illustrator;
    private String image;
    private int rarity;
    private int status;

    @Autowired
    public CardsModel() {
    }

    public CardsModel(long id, String name, int type, String firstmove, String secondmove, String ability, int weakness, int resistance, int retreat, String illustrator, String image, int rarity, int status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.firstmove = firstmove;
        this.secondmove = secondmove;
        this.ability = ability;
        this.weakness = weakness;
        this.resistance = resistance;
        this.retreat = retreat;
        this.illustrator = illustrator;
        this.image = image;
        this.rarity = rarity;
        this.status = status;
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

    public String getIllustrator() {
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

    public void setIllustrator(String illustrator) {
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
}
