package com.example.Proect.Repositories;

import com.example.Proect.Entities.EnemyPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnemyPokemonRepository extends JpaRepository<EnemyPokemon, Long> {
    public EnemyPokemon findTopByOrderByIdDesc();
}
