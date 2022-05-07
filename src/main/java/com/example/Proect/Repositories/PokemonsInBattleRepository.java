package com.example.Proect.Repositories;

import com.example.Proect.Entities.EnemyPokemon;
import com.example.Proect.Entities.PokemonsInBattle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonsInBattleRepository extends JpaRepository<PokemonsInBattle, Long> {
    public PokemonsInBattle findTopByOrderByIdDesc();
}
