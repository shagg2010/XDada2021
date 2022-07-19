package com.yadas.web.rest.controller;

import com.yadas.web.rest.model.DCUHero;
import com.yadas.web.rest.service.DCUHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dcu")
public class DCUHeroesController {

    @Autowired
    DCUHeroesService dcuHeroesService;

    @GetMapping("/heroes")
    @ResponseStatus(HttpStatus.OK )
    public List<DCUHero> getAllHeroes(){
        return dcuHeroesService.listAllHeroes();
    }

    @GetMapping("/hero/{id}")
    public DCUHero getById(@PathVariable("id") Long id){
        return dcuHeroesService.getDCUHeroById(id);
    }

    @GetMapping("/hero/like")
    public DCUHero getByHeroNameLike(@RequestParam("name") String name){
        return dcuHeroesService.getDCUHeroByName(name);
    }

    @PostMapping("/hero")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Your DCU Hero created successfully...")
    public DCUHero createHero(@RequestBody DCUHero dcuHero) {
        return dcuHeroesService.createDCUHero(dcuHero);
    }

    @PostMapping(value = "/heroes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<DCUHero> createHeroesBatch(@RequestBody List<DCUHero> dcuHeroes) {
        return dcuHeroesService.createDCUHeroes(dcuHeroes);
    }

}
