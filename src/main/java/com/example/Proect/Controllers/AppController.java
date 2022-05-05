package com.example.Proect.Controllers;

import com.example.Proect.Entities.Team;
import com.example.Proect.Entities.EnemyPokemon;
import com.example.Proect.Entities.Pokemon;
import com.example.Proect.Repositories.TeamRepository;
import com.example.Proect.Repositories.EnemyPokemonRepository;
import com.example.Proect.Repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private EnemyPokemonRepository enemyPokemonRepository;
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/")
        public String index(Model model){
            List<Pokemon> listPokemons = pokemonRepository.findAll();
            model.addAttribute("listPokemons", listPokemons);
            model.addAttribute("pokemon", new Pokemon());
            List<EnemyPokemon> listEnemyPokemons = enemyPokemonRepository.findAll();
            model.addAttribute("listEnemyPokemons", listEnemyPokemons);
            model.addAttribute("enemyPokemon", new EnemyPokemon());
            return "index";
        }

    @GetMapping("/addPokemon")
    public String addPokemon(Model model){
        model.addAttribute("pokemon", new Pokemon());
        return "addPokemon";
    }

    @GetMapping("/addEnemyPokemon")
    public String addEnemyPokemon(Model model){
        model.addAttribute("enemyPokemon", new EnemyPokemon());
        return "addEnemyPokemon";
    }

    @PostMapping("/successfully_added")
    public String added(Pokemon pokemon) {
        pokemon.setName(pokemon.getName());
        pokemon.setElement(pokemon.getElement());
        pokemon.setHealth(pokemon.getHealth());
        pokemon.setDamage(pokemon.getDamage());
        pokemon.setDefense(pokemon.getDefense());
        pokemon.setSize(pokemon.getSize());

        pokemonRepository.save(pokemon);

        return "redirect:/";
    }

    @PostMapping("/successfully_added_enemy_pokemon")
    public String addedEnemyPokemon(EnemyPokemon enemyPokemon) {
        enemyPokemon.setName(enemyPokemon.getName());
        enemyPokemon.setElement(enemyPokemon.getElement());
        enemyPokemon.setHealth(enemyPokemon.getHealth());
        enemyPokemon.setDamage(enemyPokemon.getDamage());
        enemyPokemon.setDefense(enemyPokemon.getDefense());
        enemyPokemon.setSize(enemyPokemon.getSize());

        enemyPokemonRepository.save(enemyPokemon);

        return "redirect:/";
    }

    @PostMapping("/deletePokemon/{id}")
    public String deletePokemon(@PathVariable Long id) {
        Pokemon pokemon = pokemonRepository.getById(id);
        pokemonRepository.delete(pokemon);
        return "redirect:/";
    }

    @PostMapping("deleteEnemyPokemon/{id}")
    public String deleteEnemyPokemon(@PathVariable Long id){
        EnemyPokemon enemyPokemon = enemyPokemonRepository.getById(id);
        enemyPokemonRepository.delete(enemyPokemon);
        return "redirect:/";
    }

    @GetMapping("/battle")
    public String battle(Model model){
        ArrayList<Pokemon> chosenPokemons = new ArrayList<>();
        for (Long i = 0L; i <= teamRepository.count(); i++) {
            if(i == teamRepository.count()){
                Team pokemons = teamRepository.getById(i);
                Pokemon pokemon1 = pokemonRepository.getById(pokemons.getPokemon1());
                Pokemon pokemon2 = pokemonRepository.getById(pokemons.getPokemon2());
                Pokemon pokemon3 = pokemonRepository.getById(pokemons.getPokemon3());
                chosenPokemons.add(pokemon1);
                chosenPokemons.add(pokemon2);
                chosenPokemons.add(pokemon3);
            }
        }
        model.addAttribute("listChosenPokemons", chosenPokemons);
        return "fight";
    }

    @PostMapping("/chosen")
    public String selectOption(Model model, Team pokemons, Pokemon pokemon) {
        model.addAttribute("pokemon", new Pokemon());
        Long id1 = pokemon.getPokemon1ID();

        Long id2 = pokemon.getPokemon2ID();

        Long id3 = pokemon.getPokemon3ID();

        pokemons.setPokemon1(id1);
        pokemons.setPokemon2(id2);
        pokemons.setPokemon3(id3);
        teamRepository.save(pokemons);
        model.addAttribute("teamPokemons", pokemons);

        return "redirect:/battle";
    }
}
