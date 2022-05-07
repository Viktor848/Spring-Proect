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

    private String pokemon2_name;

    private int pokemon2_health;

    private String pokemon3_name;

    private int pokemon3_health;

    private String enemyPokemon1_name;

    private int enemyPokemon1_health;

    private String enemyPokemon2_name;

    private int enemyPokemon2_health;

    private String enemyPokemon3_name;

    private int enemyPokemon3_health;

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
}
