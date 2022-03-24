package com.example.Proect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
