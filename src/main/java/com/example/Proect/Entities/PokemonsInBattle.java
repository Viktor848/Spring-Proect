package com.example.Proect.Entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_in_battle")
public class PokemonsInBattle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pokemon1ID;

    private Long pokemon2ID;

    private Long pokemon3ID;

    private Long enemyPokemon1ID;

    private Long enemyPokemon2ID;

    private Long enemyPokemon3ID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getEnemyPokemon1ID() {
        return enemyPokemon1ID;
    }

    public void setEnemyPokemon1ID(Long enemyPokemon1ID) {
        this.enemyPokemon1ID = enemyPokemon1ID;
    }

    public Long getEnemyPokemon2ID() {
        return enemyPokemon2ID;
    }

    public void setEnemyPokemon2ID(Long enemyPokemon2ID) {
        this.enemyPokemon2ID = enemyPokemon2ID;
    }

    public Long getEnemyPokemon3ID() {
        return enemyPokemon3ID;
    }

    public void setEnemyPokemon3ID(Long enemyPokemon3ID) {
        this.enemyPokemon3ID = enemyPokemon3ID;
    }
}
