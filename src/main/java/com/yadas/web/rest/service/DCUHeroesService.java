package com.yadas.web.rest.service;

import com.yadas.web.rest.model.DCUHeroes;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DCUHeroesService {

    @Autowired
    DCUHeroesRepository dcuHeroesRepository;

    public List<DCUHeroes> listAllHeroes() {
        return dcuHeroesRepository.findAll();
    }

    public DCUHeroes saveDCUHero(DCUHeroes dcuHeroes) {
        return dcuHeroesRepository.save(dcuHeroes);
    }

    public DCUHeroes getDCUHeroes(Long id) {
        return dcuHeroesRepository.findById(id).get();
    }
}
