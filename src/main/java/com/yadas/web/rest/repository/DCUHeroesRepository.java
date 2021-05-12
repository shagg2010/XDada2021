package com.yadas.web.rest.repository;

import com.yadas.web.rest.model.DCUHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DCUHeroesRepository extends JpaRepository<DCUHero, Long> {

    //this is not working
    @Query(value = "SELECT hero FROM dcu_heroes hero WHERE hero.hero_name like '% ?1 %'", nativeQuery = true)
    Optional<DCUHero> findHeroByUserName(String heroName);
}
