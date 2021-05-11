package com.yadas.web.rest.repository;

import com.yadas.web.rest.model.DCUHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCUHeroesRepository extends JpaRepository<DCUHero, Long> {
}
