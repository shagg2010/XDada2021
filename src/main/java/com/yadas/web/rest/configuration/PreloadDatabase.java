package com.yadas.web.rest.configuration;

import com.yadas.web.rest.model.DCUHero;
import com.yadas.web.rest.model.Employee;
import com.yadas.web.rest.repository.DCUHeroesRepository;
import com.yadas.web.rest.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreloadDatabase {
    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner initEmployeeDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("\t\t\tPreloading... " + repository.save(new Employee("Saurabh Yadav", "PTSE")));
            log.info("\t\t\tPreloading... " + repository.save(new Employee("Ashish Solia", "TL")));
            //log.info("\t\t\tPreloading... " + repository.save(new Employee("Chandan Kumar", "TL")));
            //log.info("\t\t\tPreloading... " + repository.save(new Employee("Gisela Rodrigues", "TL")));
            //log.info("\t\t\tPreloading... " + repository.save(new Employee("Reshmi Choudhary", "TL")));
        };
    }

    @Bean
    CommandLineRunner initDCUDatabase(DCUHeroesRepository repository) {
        return args -> {
            log.info("\t\t\tPreloading DCU Superheroes... " + repository.save(new DCUHero("Superman")));
            log.info("\t\t\tPreloading DCU Superheroes... " + repository.save(new DCUHero("Wonder Woman")));
            log.info("\t\t\tPreloading DCU Superheroes... " + repository.save(new DCUHero("Batman")));
            //log.info("\t\t\tPreloading DCU Superheroes... " + repository.save(new DCUHero("Flash")));
            //log.info("\t\t\tPreloading DCU Superheroes... " + repository.save(new DCUHero("Aquaman!")));
        };
    }
}
