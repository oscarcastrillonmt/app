/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories.crud;

import com.reto2.ciclo4.app.entities.Producto;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */

@Repository
public interface ProductoCrudRepository extends MongoRepository<Producto, String>{
    @Query("{categoria:?0}")
    List<Producto>getProductoMarca(String categoria);
}
