package com.yadas.web.rest.repository;

import com.yadas.web.rest.model.ShoppingCart;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ShoppingCartRepository extends CassandraRepository<ShoppingCart, String> {
}
