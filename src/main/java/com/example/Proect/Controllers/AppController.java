package com.example.Proect.Controllers;

import com.example.Proect.Entities.PokemonsInBattle;
import com.example.Proect.Entities.Team;
import com.example.Proect.Entities.EnemyPokemon;
import com.example.Proect.Entities.Pokemon;
import com.example.Proect.Repositories.PokemonsInBattleRepository;
import com.example.Proect.Repositories.TeamRepository;
import com.example.Proect.Repositories.EnemyPokemonRepository;
import com.example.Proect.Repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private EnemyPokemonRepository enemyPokemonRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PokemonsInBattleRepository pokemonsInBattleRepository;

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
    public String battle(Model model, PokemonsInBattle pokemonsInBattle){
        ArrayList<Pokemon> chosenPokemons = new ArrayList<>();
        for (Long i = 0L; i <= teamRepository.count(); i++) {
            if(i == teamRepository.count()){
                Team pokemons = teamRepository.getById(i);
                Pokemon pokemon1 = pokemonRepository.getById(pokemons.getPokemon1());
                Pokemon pokemon2 = pokemonRepository.getById(pokemons.getPokemon2());
                Pokemon pokemon3 = pokemonRepository.getById(pokemons.getPokemon3());
                chosenPokemons.add(pokemon1);
                pokemonsInBattle.setPokemon1_name(pokemon1.getName());
                pokemonsInBattle.setPokemon1_health(pokemon1.getHealth());
                chosenPokemons.add(pokemon2);
                pokemonsInBattle.setPokemon2_name(pokemon2.getName());
                pokemonsInBattle.setPokemon2_health(pokemon2.getHealth());
                chosenPokemons.add(pokemon3);
                pokemonsInBattle.setPokemon3_name(pokemon3.getName());
                pokemonsInBattle.setPokemon3_health(pokemon3.getHealth());
            }
        }

        ArrayList<EnemyPokemon> enemyPokemons = new ArrayList<>();
        EnemyPokemon lastID = enemyPokemonRepository.findTopByOrderByIdDesc();
        ArrayList<Long> ids = new ArrayList<>();
        ArrayList<Long> ids2 = new ArrayList<>();
        while (enemyPokemons.size() < 3) {
            long leftLimit = 1L;
            long rightLimit = lastID.getId();
            long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

            for (Long i = leftLimit; i <= rightLimit; i++) {
                ids.add(i);
            }
            Collections.shuffle(ids);
            for (int i = 0; i < ids.size(); i++) {
                    if (enemyPokemonRepository.existsById(ids.get(i))) {
                        ids2.add(ids.get(i));
                    }
            }
            for (int i = 0; i < 3; i++) {
                enemyPokemons.add(enemyPokemonRepository.getById(ids2.get(i)));
            }
            pokemonsInBattle.setEnemyPokemon1_name(enemyPokemonRepository.getById(ids2.get(0)).getName());
            pokemonsInBattle.setEnemyPokemon1_health(enemyPokemonRepository.getById(ids2.get(0)).getHealth());
            pokemonsInBattle.setEnemyPokemon2_name(enemyPokemonRepository.getById(ids2.get(1)).getName());
            pokemonsInBattle.setEnemyPokemon2_health(enemyPokemonRepository.getById(ids2.get(1)).getHealth());
            pokemonsInBattle.setEnemyPokemon3_name(enemyPokemonRepository.getById(ids2.get(2)).getName());
            pokemonsInBattle.setEnemyPokemon3_health(enemyPokemonRepository.getById(ids2.get(2)).getHealth());
        }
        pokemonsInBattleRepository.save(pokemonsInBattle);
        ArrayList<PokemonsInBattle> pokemonsInBattleList = new ArrayList<>();
        PokemonsInBattle lastRow = pokemonsInBattleRepository.findTopByOrderByIdDesc();
        pokemonsInBattleList.add(pokemonsInBattleRepository.getById(lastRow.getId()));

        model.addAttribute("pokemonInBattle", new PokemonsInBattle());
        model.addAttribute("pokemon1Name", pokemonsInBattleList.get(0).getPokemon1_name());
        model.addAttribute("pokemon1Health", pokemonsInBattleList.get(0).getPokemon1_health());
        model.addAttribute("pokemon2Name", pokemonsInBattleList.get(0).getPokemon2_name());
        model.addAttribute("pokemon2Health", pokemonsInBattleList.get(0).getPokemon2_health());
        model.addAttribute("pokemon3Name", pokemonsInBattleList.get(0).getPokemon3_name());
        model.addAttribute("pokemon3Health", pokemonsInBattleList.get(0).getPokemon3_health());
        model.addAttribute("enemyPokemon1Name", pokemonsInBattleList.get(0).getEnemyPokemon1_name());
        model.addAttribute("enemyPokemon1Health", pokemonsInBattleList.get(0).getEnemyPokemon1_health());
        model.addAttribute("enemyPokemon2Name", pokemonsInBattleList.get(0).getEnemyPokemon2_name());
        model.addAttribute("enemyPokemon2Health", pokemonsInBattleList.get(0).getEnemyPokemon2_health());
        model.addAttribute("enemyPokemon3Name", pokemonsInBattleList.get(0).getEnemyPokemon3_name());
        model.addAttribute("enemyPokemon3Health", pokemonsInBattleList.get(0).getEnemyPokemon3_health());
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
