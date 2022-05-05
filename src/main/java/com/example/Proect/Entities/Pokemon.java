package com.example.Proect.Entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String element;

    @NotNull
    private int health;

    @NotNull
    private int damage;

    @NotNull
    private int defense;

    @NotNull
    private String size;

    private Long pokemon1ID;

    private Long pokemon2ID;

    private Long pokemon3ID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPokemon1ID() {
        return pokemon1ID;
    }

    public void setPokemon1ID(Long pokemon1ID) {
        this.pokemon1ID = pokemon1ID;
    }

    public Long getPokemon2ID() {
        return pokemon2ID;
    }

    public void setPokemon2ID(Long pokemon2ID) {
        this.pokemon2ID = pokemon2ID;
    }

    public Long getPokemon3ID() {
        return pokemon3ID;
    }

    public void setPokemon3ID(Long pokemon3ID) {
        this.pokemon3ID = pokemon3ID;
    }
}

