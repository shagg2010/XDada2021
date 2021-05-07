package com.yadas.web.rest.controller;

import com.yadas.web.rest.model.DCUHeroes;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import com.yadas.web.rest.service.DCUHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DCUHeroesController {

    @Autowired
    DCUHeroesService dcuHeroesService;

    @GetMapping("/dcuheroes")
    public List<DCUHeroes> getAllHeroes(){
        return dcuHeroesService.listAllHeroes();
    }

    @PostMapping("/dcuheroes")
    public DCUHeroes createHero(@RequestBody DCUHeroes dcuHeroes) {
        return dcuHeroesService.saveDCUHero(dcuHeroes);
    }
}
