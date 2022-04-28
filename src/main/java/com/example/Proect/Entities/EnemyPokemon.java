package com.example.Proect.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "enemy_pokemons")
public class EnemyPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2,max = 20, message = "Pokemon name must have at least 2 characters")
    private String name;

    @NotNull
    @Size(min = 2,max = 30)
    private String element;

    @NotNull
    @Size(min = 1,max = 100,message = "Type a number between 1 and 100")
    private int health;

    @NotNull
    @Size(min = 1,max = 100,message = "Type a number between 1 and 100")
    private int damage;

    @NotNull
    @Size(min = 1,max = 100,message = "Type a number between 1 and 100")
    private int defense;

    @NotNull
    @Size(min = 1,max = 100,message = "Type number between 1 and 100")
    private String size;

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
}
