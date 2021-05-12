package com.yadas.web.rest.service;

import com.yadas.web.rest.exception.HeroNotFoundException;
import com.yadas.web.rest.model.DCUHero;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DCUHeroesService {

    private static final Logger logger = LoggerFactory.getLogger(DCUHeroesService.class);

    @Autowired
    DCUHeroesRepository dcuHeroesRepository;

    public List<DCUHero> listAllHeroes() {
        return dcuHeroesRepository.findAll();
    }

    public DCUHero createDCUHero(DCUHero dcuHero) {
        return dcuHeroesRepository.save(dcuHero);
    }

    public List<DCUHero> createDCUHeroes(List<DCUHero> dcuHeroes) {
        List<DCUHero> list = new ArrayList<>();
        for (DCUHero dcuHero: dcuHeroes) {
            list.add(dcuHeroesRepository.save(dcuHero));
        }
        return list;
    }

    public DCUHero getDCUHeroById(Long id) {
        Optional<DCUHero> dcuHero = dcuHeroesRepository.findById(id);
        if(!dcuHero.isPresent()){
            logger.error("No DCU Hero found in database with id: " + id);
            throw new HeroNotFoundException("No DCU Hero found in database with id: " + id);
        }
        return dcuHero.get();
    }
}
