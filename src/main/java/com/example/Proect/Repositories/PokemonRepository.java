package com.example.Proect.Repositories;

import com.example.Proect.Entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    public void delete(int id);
}
