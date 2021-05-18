package com.yadas.web.rest;

import ch.qos.logback.core.util.COWArrayList;
import com.yadas.web.rest.model.DCUHero;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitMokitoTests {

    @Autowired
    private DCUHeroesRepository dcuHeroesRepository;

    @Test
    public void whenfindAllHeroes_thenReturnAll_IsSuccess(){
        DCUHero[] dcuHeroes = new DCUHero[] {new DCUHero("Superman"),new DCUHero("Wonder Woman"),new DCUHero("Batman")};
        List<DCUHero> listAll = Stream.of(dcuHeroes).collect(Collectors.toList());
        Mockito.when(dcuHeroesRepository.findAll()).thenReturn(listAll);

        assertEquals(listAll,dcuHeroesRepository.findAll());
        assertEquals(listAll.size(),3);
    }

}
