package com.yadas.web.rest.repository;

import com.yadas.web.rest.model.DCUHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DCUHeroesRepository extends JpaRepository<DCUHero, Long> {

    /*@Query("select heroes from dcu_heroes dcu_heroes where heroname like %?1%")
    DCUHero findHeroByUserName(String heroName);*/
}
