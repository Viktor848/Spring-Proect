package com.example.Proect.Entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pokemon1;

    private Long pokemon2;

    private Long pokemon3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Long pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Long getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Long pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Long getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(Long pokemon3) {
        this.pokemon3 = pokemon3;
    }
}
