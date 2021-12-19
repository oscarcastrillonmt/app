/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories;

import com.reto2.ciclo4.app.entities.Vegetarian;
import com.reto2.ciclo4.app.repositories.crud.ProductoCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */
@Repository
public class ProductoRepository {
    
    @Autowired
    private ProductoCrudRepository repositorioCrud;
    
    public List<Vegetarian> getAll() {
        return repositorioCrud.findAll();
    }

    public Optional<Vegetarian> getproduct(String reference) {
        return repositorioCrud.findById(reference);
    }
    
    public Vegetarian create(Vegetarian clothe) {
        return repositorioCrud.save(clothe);
    }

    public void update(Vegetarian reference) {
        repositorioCrud.save(reference);
    }
    
    public void delete(Vegetarian reference) {
        repositorioCrud.delete(reference);
    } 
    
    
    //Reto 5
    public List<Vegetarian> productByPrice(double precio){
        return repositorioCrud.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description){
        return repositorioCrud.findByDescriptionLike(description);
    }
    
}
