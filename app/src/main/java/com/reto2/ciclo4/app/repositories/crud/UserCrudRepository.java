/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories.crud;

import com.reto2.ciclo4.app.entities.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */


public interface UserCrudRepository extends MongoRepository <User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    
    //Selecciona usuario con el Id Maximo o el ultimo Id
    Optional<User> findTopByOrderByIdDesc();
    
}
