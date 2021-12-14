/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.controllers;

import com.reto2.ciclo4.app.entities.Vegetarian;
import com.reto2.ciclo4.app.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oacas
 */
@RestController
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.DELETE,
                                   RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/vegetarian")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")
    public List<Vegetarian> getProducto(){
        return service.getProductos();
    }
    
    @GetMapping("/{id}")
    public Vegetarian getProductoId(@PathVariable("id") String id){
        return service.getProductoId(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity addProducto(@RequestBody Vegetarian producto){
        service.saveProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateProducto(@RequestBody Vegetarian producto){
        service.updateProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable String id){
        service.deleteProducto(id);
        return ResponseEntity.status(204).build();
    }
}
