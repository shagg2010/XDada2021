package com.yadas.web.rest.repository;

import com.yadas.web.rest.model.DCUHeroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCUHeroesRepository extends JpaRepository<DCUHeroes, Long> {
}
