package com.yadas.web.rest.controller;

import com.yadas.web.rest.model.ShoppingCart;
import com.yadas.web.rest.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cassandra")
public class CassandraController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @PostConstruct
    public void loadUsers(){
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        shoppingCarts.add(new ShoppingCart("1510", 5, Timestamp.from(Instant.now())));
        shoppingCarts.add(new ShoppingCart("1515", 15, Timestamp.from(Instant.now())));
        shoppingCartRepository.saveAll(shoppingCarts);
    }

    @GetMapping("/getAllShoppingCarts")
    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartRepository.findAll();
    }

    @GetMapping("/getShoppingCartById/{id}")
    public Optional<ShoppingCart> getShoppingCartById(@PathVariable String id){
        return shoppingCartRepository.findById(id);
    }
}
