/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.controllers;

import com.reto2.ciclo4.app.entities.Producto;
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
@RequestMapping("/api/Producto")
public class ProductoController {
    
    @Autowired
    private ProductoService service;
    
    @GetMapping("/all")
    public List<Producto> getProducto(){
        return service.getProductos();
    }
    
    @PostMapping("/save")
    public ResponseEntity addProducto(@RequestBody Producto producto){
        service.saveProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateProducto(@RequestBody Producto producto){
        service.updateProducto(producto);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable String id){
        service.deleteProducto(id);
        return ResponseEntity.status(204).build();
    }
}
