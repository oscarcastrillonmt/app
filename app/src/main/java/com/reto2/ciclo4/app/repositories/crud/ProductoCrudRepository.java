/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories.crud;

import com.reto2.ciclo4.app.entities.Vegetarian;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */


public interface ProductoCrudRepository extends MongoRepository<Vegetarian, String>{
    
      //Reto 5
    public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Vegetarian> findByDescriptionLike(String description);
   
}
