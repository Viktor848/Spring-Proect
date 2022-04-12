package com.example.Proect.Repositories;

import com.example.Proect.Entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
