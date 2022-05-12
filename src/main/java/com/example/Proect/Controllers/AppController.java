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

import java.util.*;

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
                pokemonsInBattle.setPokemon1ID(pokemon1.getId());
                chosenPokemons.add(pokemon2);
                pokemonsInBattle.setPokemon2ID(pokemon2.getId());
                chosenPokemons.add(pokemon3);
                pokemonsInBattle.setPokemon3ID(pokemon3.getId());
            }
        }

        ArrayList<EnemyPokemon> enemyPokemons = new ArrayList<>();
        EnemyPokemon lastID = enemyPokemonRepository.findTopByOrderByIdDesc();
        ArrayList<Long> ids = new ArrayList<>();
        ArrayList<Long> ids2 = new ArrayList<>();
        while (enemyPokemons.size() < 3) {
            long leftLimit = 1L;
            long rightLimit = lastID.getId();

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
            pokemonsInBattle.setEnemyPokemon1ID(enemyPokemonRepository.getById(ids2.get(0)).getId());
            pokemonsInBattle.setEnemyPokemon2ID(enemyPokemonRepository.getById(ids2.get(1)).getId());
            pokemonsInBattle.setEnemyPokemon3ID(enemyPokemonRepository.getById(ids2.get(2)).getId());
        }

        pokemonsInBattleRepository.save(pokemonsInBattle);
        ArrayList<PokemonsInBattle> pokemonsInBattleList = new ArrayList<>();
        PokemonsInBattle lastRow = pokemonsInBattleRepository.findTopByOrderByIdDesc();
        pokemonsInBattleList.add(pokemonsInBattleRepository.getById(lastRow.getId()));

        ArrayList<Pokemon> pokemonTeam = new ArrayList<>();
        Pokemon pokemon1 = pokemonRepository.getById(pokemonsInBattle.getPokemon1ID());
        Pokemon pokemon2 = pokemonRepository.getById(pokemonsInBattle.getPokemon2ID());
        Pokemon pokemon3 = pokemonRepository.getById(pokemonsInBattle.getPokemon3ID());
        pokemonTeam.add(pokemon1);
        pokemonTeam.add(pokemon2);
        pokemonTeam.add(pokemon3);

        ArrayList<EnemyPokemon> enemyTeam = new ArrayList<>();
        EnemyPokemon enemyPokemon1 = enemyPokemonRepository.getById(pokemonsInBattle.getEnemyPokemon1ID());
        EnemyPokemon enemyPokemon2 = enemyPokemonRepository.getById(pokemonsInBattle.getEnemyPokemon2ID());
        EnemyPokemon enemyPokemon3 = enemyPokemonRepository.getById(pokemonsInBattle.getEnemyPokemon3ID());
        enemyTeam.add(enemyPokemon1);
        enemyTeam.add(enemyPokemon2);
        enemyTeam.add(enemyPokemon3);

        model.addAttribute("pokemon", new Pokemon());
        model.addAttribute("enemyPokemon", new EnemyPokemon());
        model.addAttribute("pokemonTeam", pokemonTeam);
        model.addAttribute("enemyTeam", enemyTeam);

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

    @PostMapping("/battle/attack")
    public String attack(Model model){
        Optional<PokemonsInBattle> pokemonsInBattle = pokemonsInBattleRepository.findById(pokemonsInBattleRepository.count());
        ArrayList<Pokemon> pokemonTeam = new ArrayList<>();
        Pokemon pokemon1 = pokemonRepository.getById(pokemonsInBattle.get().getPokemon1ID());
        Pokemon pokemon2 = pokemonRepository.getById(pokemonsInBattle.get().getPokemon2ID());
        Pokemon pokemon3 = pokemonRepository.getById(pokemonsInBattle.get().getPokemon3ID());
        pokemonTeam.add(pokemon1);
        pokemonTeam.add(pokemon2);
        pokemonTeam.add(pokemon3);


        ArrayList<EnemyPokemon> enemyTeam = new ArrayList<>();
        EnemyPokemon enemyPokemon1 = enemyPokemonRepository.getById(pokemonsInBattle.get().getEnemyPokemon1ID());
        EnemyPokemon enemyPokemon2 = enemyPokemonRepository.getById(pokemonsInBattle.get().getEnemyPokemon2ID());
        EnemyPokemon enemyPokemon3 = enemyPokemonRepository.getById(pokemonsInBattle.get().getEnemyPokemon3ID());
        enemyTeam.add(enemyPokemon1);
        enemyTeam.add(enemyPokemon2);
        enemyTeam.add(enemyPokemon3);

        Random random = new Random();

            while (enemyPokemon1.getHealth() > 0) {
                int randomDamage = random.nextInt(pokemonTeam.get(0).getDamage());
                int dealtDamage = enemyTeam.get(0).getHealth() - randomDamage;
                enemyTeam.get(0).setHealth(dealtDamage);

                model.addAttribute("enemyPokemon1", enemyPokemon1);
                model.addAttribute("enemyPokemon2", enemyPokemon2);
                model.addAttribute("enemyPokemon3", enemyPokemon3);
            }

            if (enemyPokemon1.getHealth() <= 0) {
                int randomDamage = random.nextInt(pokemonTeam.get(0).getDamage());
                int dealtDamage = enemyTeam.get(1).getHealth() - randomDamage;
                enemyTeam.get(1).setHealth(dealtDamage);

                model.addAttribute("enemyPokemon1", enemyPokemon2);
                model.addAttribute("enemyPokemon2", enemyPokemon3);
                model.addAttribute("enemyPokemon3", enemyPokemon1);
            }

            if (enemyPokemon1.getHealth() <= 0 && enemyPokemon2.getHealth() <= 0) {
                int randomDamage = random.nextInt(pokemonTeam.get(0).getDamage());
                int dealtDamage = enemyTeam.get(2).getHealth() - randomDamage;
                enemyTeam.get(2).setHealth(dealtDamage);

                model.addAttribute("enemyPokemon1", enemyPokemon3);
                model.addAttribute("enemyPokemon2", enemyPokemon2);
                model.addAttribute("enemyPokemon3", enemyPokemon1);
            }

        return "duringFight";
    }

//    @PostMapping("/battle/heal")
//
//    public String heal(Model model){
//        Optional<PokemonsInBattle> pokemonsInBattle = pokemonsInBattleRepository.findById(pokemonsInBattleRepository.count());
//        Random random = new Random();
//        int randomHeal = random.nextInt(pokemonsInBattle.get().getPokemon1_health() / 2);
//        int healed = pokemonsInBattle.get().getPokemon1_health() + randomHeal;
//        pokemonsInBattle.get().setPokemon1_health(healed);
//        model.addAttribute("pokemonInBattle", new PokemonsInBattle());
//        model.addAttribute("pokemon1Name", pokemonsInBattle.get().getPokemon1_name());
//        model.addAttribute("pokemon1Health", pokemonsInBattle.get().getPokemon1_health());
//        model.addAttribute("pokemon2Name", pokemonsInBattle.get().getPokemon2_name());
//        model.addAttribute("pokemon2Health", pokemonsInBattle.get().getPokemon2_health());
//        model.addAttribute("pokemon3Name", pokemonsInBattle.get().getPokemon3_name());
//        model.addAttribute("pokemon3Health", pokemonsInBattle.get().getPokemon3_health());
//        model.addAttribute("enemyPokemon1Name", pokemonsInBattle.get().getEnemyPokemon1_name());
//        model.addAttribute("enemyPokemon1Health", pokemonsInBattle.get().getEnemyPokemon1_health());
//        model.addAttribute("enemyPokemon2Name", pokemonsInBattle.get().getEnemyPokemon2_name());
//        model.addAttribute("enemyPokemon2Health", pokemonsInBattle.get().getEnemyPokemon2_health());
//        model.addAttribute("enemyPokemon3Name", pokemonsInBattle.get().getEnemyPokemon3_name());
//        model.addAttribute("enemyPokemon3Health", pokemonsInBattle.get().getEnemyPokemon3_health());
//        pokemonsInBattleRepository.save(pokemonsInBattle.get());
//        return "duringFight";
//    }
}
