/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.controllers;

import com.reto2.ciclo4.app.entities.User;
import com.reto2.ciclo4.app.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService servicio;
    
    /**
     * GET
     * @return 
     */
    
    @GetMapping("/all")
    public List<User> listar(){
        return servicio.listar();
    }
    
    
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return servicio.getUser(id);
    }
    
    /**
     * GET
     * email exist
     */
    
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable ("email") String email){
        return servicio.existeEmail(email);
    }
    
    /**
     * GET
     * email exist
     */
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable ("email") String email, @PathVariable("password") String password){
        return servicio.autenticarUsuario(email, password);
    }
    
    /**
     * POST
     */
    
    @PostMapping("/new")
    public ResponseEntity addUser(@RequestBody User user){
        servicio.create(user);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return servicio.update(user);
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
