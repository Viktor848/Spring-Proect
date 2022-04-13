package com.example.Proect.Repositories;

import com.example.Proect.Entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChosenPokemonsRepository extends JpaRepository<Pokemon, Long> {
}
