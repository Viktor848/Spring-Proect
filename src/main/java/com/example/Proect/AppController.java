package com.example.Proect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Pokemon> listPokemons = pokemonRepository.findAll();
        model.addAttribute("listPokemons", listPokemons);
        return "index";
    }

    @GetMapping("/addPokemon")
    public String addPokemon(Model model){
        model.addAttribute("pokemon", new Pokemon());
        return "addPokemon";
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

}
