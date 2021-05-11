package com.yadas.web.rest.controller;

import com.yadas.web.rest.controller.exceptions.HeroNotFoundException;
import com.yadas.web.rest.model.DCUHeroes;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import com.yadas.web.rest.service.DCUHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dcu")
public class DCUHeroesController {

    @Autowired
    DCUHeroesService dcuHeroesService;

    @GetMapping("/heroes")
    @ResponseStatus(HttpStatus.OK )
    public List<DCUHeroes> getAllHeroes(){
        return dcuHeroesService.listAllHeroes();
    }

    @GetMapping("/hero/{id}")
    public DCUHeroes getById(@PathVariable("id") Long id){
        return dcuHeroesService.getDCUHeroById(id);
    }

    @PostMapping("/hero")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Your DCU Hero created successfully...")
    public DCUHeroes createHero(@RequestBody DCUHeroes dcuHeroes) {
        return dcuHeroesService.createDCUHero(dcuHeroes);
    }

    @PostMapping(value = "/heroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<DCUHeroes> createHeroesBatch(@RequestBody List<DCUHeroes> dcuHeroes) {
        return dcuHeroesService.createDCUHeroes(dcuHeroes);
    }

}
