package com.yadas.web.rest.configuration;

import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import org.mockito.Mockito;

@Profile("test")
@Configuration
public class MokitoTestConfig {

    @Bean
    @Primary
    public DCUHeroesRepository dcuHeroesRepository(){
        return Mockito.mock(DCUHeroesRepository.class);
    }

}
