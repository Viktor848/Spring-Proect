package com.example.Proect.Controllers;

import com.example.Proect.Entities.EnemyPokemon;
import com.example.Proect.Entities.Pokemon;
import com.example.Proect.Repositories.EnemyPokemonRepository;
import com.example.Proect.Repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private EnemyPokemonRepository enemyPokemonRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Pokemon> listPokemons = pokemonRepository.findAll();
        model.addAttribute("listPokemons", listPokemons);
        List<EnemyPokemon> listEnemyPokemons = enemyPokemonRepository.findAll();
        model.addAttribute("listEnemyPokemons", listEnemyPokemons);
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

        return "index";
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

        return "index";
    }

    @PostMapping("/successfully_deleted_pokemon")
    public String delete(@PathVariable("id") int id) {
//        pokemonRepository.delete(id);
        return "index";
    }

    @PostMapping("/successfully_deleted_enemy_pokemon")
    public String deleteEnemyPokemon(@PathVariable("id") int id) {
//        enemyPokemonRepository.remove(id);
        return "index";
    }

    @GetMapping("/battle")
    public String battle(){
        return "fight";
    }

}
