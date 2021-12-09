/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories;

import com.reto2.ciclo4.app.entities.User;
import com.reto2.ciclo4.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */

@Repository
public class UserRepository {
    
    @Autowired 
    private UserCrudRepository repositorioCrud;
    
    public List<User> listar(){
        return repositorioCrud.findAll();
    }
    
    public boolean existeEmail(String email) {
        Optional<User> emailExiste=repositorioCrud.findByEmail(email);
        return emailExiste.isPresent();
    }
    
    public Optional<User> autenticarUsuario(String email, String password){
        return repositorioCrud.findByEmailAndPassword(email, password);
        
    }
    
    public User create(User user){
       return repositorioCrud.save(user);
    }
    
    public User update(User user){
       return repositorioCrud.save(user);
    }
    
    public Optional<User> getUser(Integer id){
        return repositorioCrud.findById(id);
        
    }
    public void delete(User user){
        repositorioCrud.delete(user);
    }
    
    public Optional<User> lastUserId(){
        return repositorioCrud.findTopByOrderByIdDesc();
        
    }
}
