package com.yadas.web.rest;

import com.yadas.web.rest.repository.DCUHeroesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApplicationTests {

	@Autowired
	DCUHeroesRepository dcuHeroesRepository;

	@Test
	void contextLoads() {
	}

}
