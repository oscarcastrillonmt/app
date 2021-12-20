/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.services;

import com.reto2.ciclo4.app.entities.Vegetarian;
import com.reto2.ciclo4.app.repositories.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author oacas
 */

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    public List<Vegetarian> getProductos(){
        return repository.getAll();
    }
    
    public Vegetarian create(Vegetarian producto) {
        if (producto.getReference() == null) {
            return producto;
        } else {
            return repository.create(producto);
        }
    }
    
    public Optional<Vegetarian> getProductoId(String reference) {
        return repository.getproduct(reference);
    }
    
    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = repository.getproduct(accesory.getReference());
            if (accesoryDb.isPresent()) {

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }
    
//    public Vegetarian updateProducto(Vegetarian producto){
//        Optional<Vegetarian> producto_anterior= getProductoId(producto.getReference());
//        
//        producto_anterior.setBrand(producto.getBrand());
//        producto_anterior.setCategory(producto.getCategory());
//        producto_anterior.setDescription(producto.getDescription());
//        producto_anterior.setAvailability(producto.isAvailability());
//        producto_anterior.setPrice(producto.getPrice());
//        producto_anterior.setQuantity(producto.getQuantity());
//        producto_anterior.setPhotography(producto.getPhotography());
//        
//        return repository.create(producto_anterior);
//    }
    
   public boolean delete(String reference) {
        Boolean aBoolean = getProductoId(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
        
    //Reto 5
    public List<Vegetarian> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<Vegetarian> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
    
}
