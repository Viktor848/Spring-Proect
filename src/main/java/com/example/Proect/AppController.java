package com.example.Proect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
