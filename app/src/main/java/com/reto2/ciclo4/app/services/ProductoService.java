/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.services;

import com.reto2.ciclo4.app.entities.Vegetarian;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto2.ciclo4.app.repositories.crud.ProductoCrudRepository;

/**
 *
 * @author oacas
 */

@Service
public class ProductoService {
    
    @Autowired
    private ProductoCrudRepository repository;
    
    public List<Vegetarian> getProductos(){
        return repository.findAll();
    }
    
    public Vegetarian saveProducto(Vegetarian producto){
        return repository.save(producto);
    }
    
    public Vegetarian getProductoId(String id){
        return repository.findById(id).orElse(null);
    }
    
    
    public Vegetarian updateProducto(Vegetarian producto){
        Vegetarian producto_anterior= getProductoId(producto.getReference());
        
        producto_anterior.setBrand(producto.getBrand());
        producto_anterior.setCategory(producto.getCategory());
        producto_anterior.setDescription(producto.getDescription());
        producto_anterior.setAvailability(producto.isAvailability());
        producto_anterior.setPrice(producto.getPrice());
        producto_anterior.setQuantity(producto.getQuantity());
        producto_anterior.setPhotography(producto.getPhotography());
        
        return repository.save(producto_anterior);
    }
    
    public void deleteProducto(String reference){
        repository.deleteById(reference);
    }
    
}
