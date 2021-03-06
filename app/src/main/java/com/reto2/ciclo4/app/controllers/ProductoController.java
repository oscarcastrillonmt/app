/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.controllers;

import com.reto2.ciclo4.app.entities.Vegetarian;
import com.reto2.ciclo4.app.services.ProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oacas
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/vegetarian")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")
    public List<Vegetarian> getProducto(){
        return service.getProductos();
    }
    
    @GetMapping("/{id}")
    public Optional<Vegetarian> getProductoId(@PathVariable("id") String id){
        return service.getProductoId(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian create(@RequestBody Vegetarian producto) {
        return service.create(producto);
    }
    
    @PutMapping("/update")
    public ResponseEntity updateProducto(@RequestBody Vegetarian producto){
        service.update(producto);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
    
    @GetMapping("/price/{price}")
    public List<Vegetarian> productByPrice(@PathVariable("price") double precio) {
        return service.productByPrice(precio);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Vegetarian> findByDescriptionLike(@PathVariable("description") String description) {
        return service.findByDescriptionLike(description);
    }
}

