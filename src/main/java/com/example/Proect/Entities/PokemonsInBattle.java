package com.example.Proect.Entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_in_battle")
public class PokemonsInBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pokemon1_name;

    private int pokemon1_health;

    private int pokemon1_damage;

    private String pokemon2_name;

    private int pokemon2_health;

    private int pokemon2_damage;

    private String pokemon3_name;

    private int pokemon3_health;

    private int pokemon3_damage;

    private String enemyPokemon1_name;

    private int enemyPokemon1_health;

    private int enemyPokemon1_damage;

    private String enemyPokemon2_name;

    private int enemyPokemon2_health;

    private int enemyPokemon2_damage;

    private String enemyPokemon3_name;

    private int enemyPokemon3_health;

    private int enemyPokemon3_damage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPokemon1_name() {
        return pokemon1_name;
    }

    public void setPokemon1_name(String pokemon1_name) {
        this.pokemon1_name = pokemon1_name;
    }

    public int getPokemon1_health() {
        return pokemon1_health;
    }

    public void setPokemon1_health(int pokemon1_health) {
        this.pokemon1_health = pokemon1_health;
    }

    public int getPokemon1_damage() {
        return pokemon1_damage;
    }

    public void setPokemon1_damage(int pokemon1_damage) {
        this.pokemon1_damage = pokemon1_damage;
    }

    public String getPokemon2_name() {
        return pokemon2_name;
    }

    public void setPokemon2_name(String pokemon2_name) {
        this.pokemon2_name = pokemon2_name;
    }

    public int getPokemon2_health() {
        return pokemon2_health;
    }

    public void setPokemon2_health(int pokemon2_health) {
        this.pokemon2_health = pokemon2_health;
    }

    public int getPokemon2_damage() {
        return pokemon2_damage;
    }

    public void setPokemon2_damage(int pokemon2_damage) {
        this.pokemon2_damage = pokemon2_damage;
    }

    public String getPokemon3_name() {
        return pokemon3_name;
    }

    public void setPokemon3_name(String pokemon3_name) {
        this.pokemon3_name = pokemon3_name;
    }

    public int getPokemon3_health() {
        return pokemon3_health;
    }

    public void setPokemon3_health(int pokemon3_health) {
        this.pokemon3_health = pokemon3_health;
    }

    public int getPokemon3_damage() {
        return pokemon3_damage;
    }

    public void setPokemon3_damage(int pokemon3_damage) {
        this.pokemon3_damage = pokemon3_damage;
    }

    public String getEnemyPokemon1_name() {
        return enemyPokemon1_name;
    }

    public void setEnemyPokemon1_name(String enemyPokemon1_name) {
        this.enemyPokemon1_name = enemyPokemon1_name;
    }

    public int getEnemyPokemon1_health() {
        return enemyPokemon1_health;
    }

    public void setEnemyPokemon1_health(int enemyPokemon1_health) {
        this.enemyPokemon1_health = enemyPokemon1_health;
    }

    public int getEnemyPokemon1_damage() {
        return enemyPokemon1_damage;
    }

    public void setEnemyPokemon1_damage(int enemyPokemon1_damage) {
        this.enemyPokemon1_damage = enemyPokemon1_damage;
    }

    public String getEnemyPokemon2_name() {
        return enemyPokemon2_name;
    }

    public void setEnemyPokemon2_name(String enemyPokemon2_name) {
        this.enemyPokemon2_name = enemyPokemon2_name;
    }

    public int getEnemyPokemon2_health() {
        return enemyPokemon2_health;
    }

    public void setEnemyPokemon2_health(int enemyPokemon2_health) {
        this.enemyPokemon2_health = enemyPokemon2_health;
    }

    public int getEnemyPokemon2_damage() {
        return enemyPokemon2_damage;
    }

    public void setEnemyPokemon2_damage(int enemyPokemon2_damage) {
        this.enemyPokemon2_damage = enemyPokemon2_damage;
    }

    public String getEnemyPokemon3_name() {
        return enemyPokemon3_name;
    }

    public void setEnemyPokemon3_name(String enemyPokemon3_name) {
        this.enemyPokemon3_name = enemyPokemon3_name;
    }

    public int getEnemyPokemon3_health() {
        return enemyPokemon3_health;
    }

    public void setEnemyPokemon3_health(int enemyPokemon3_health) {
        this.enemyPokemon3_health = enemyPokemon3_health;
    }

    public int getEnemyPokemon3_damage() {
        return enemyPokemon3_damage;
    }

    public void setEnemyPokemon3_damage(int enemyPokemon3_damage) {
        this.enemyPokemon3_damage = enemyPokemon3_damage;
    }
}