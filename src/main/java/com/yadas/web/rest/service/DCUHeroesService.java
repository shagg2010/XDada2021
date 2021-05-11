package com.yadas.web.rest.service;

import com.yadas.web.rest.controller.exceptions.HeroNotFoundException;
import com.yadas.web.rest.model.DCUHeroes;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DCUHeroesService {

    @Autowired
    DCUHeroesRepository dcuHeroesRepository;

    public List<DCUHeroes> listAllHeroes() {
        return dcuHeroesRepository.findAll();
    }

    public DCUHeroes createDCUHero(DCUHeroes dcuHero) {
        return dcuHeroesRepository.save(dcuHero);
    }

    public List<DCUHeroes> createDCUHeroes(List<DCUHeroes> dcuHeroes) {
        List<DCUHeroes> list = new ArrayList<>();
        for (DCUHeroes dcuHero: dcuHeroes) {
            list.add(dcuHeroesRepository.save(dcuHero));
        }
        return list;
    }

    public DCUHeroes getDCUHeroById(Long id) {
        Optional<DCUHeroes> dcuHero = dcuHeroesRepository.findById(id);
        if(!dcuHero.isPresent()){
            throw new HeroNotFoundException("No DCU Hero found in database with id: " + id);
        }
        return dcuHero.get();
    }
}
