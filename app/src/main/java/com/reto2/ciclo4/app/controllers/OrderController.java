/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto2.ciclo4.app.controllers;

import com.reto2.ciclo4.app.entities.Order;
import com.reto2.ciclo4.app.entities.User;
import com.reto2.ciclo4.app.services.OrderService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oacas
 */
@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    
    @Autowired
    
    private OrderService servicio;
    
    /**
     * GET
     */
    
    @GetMapping("/all")
    public List<Order> getAll(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id){
        return servicio.getOrder(id);
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona){
        return servicio.findByZone(zona);
    }
    
    /**
     * POST
     */
    
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody Order order){
        servicio.create(order);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return servicio.update(order);
    }
    
    /**
     * DELETE
     */
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return servicio.delete(id);
    }
}
