/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto2.ciclo4.app.repositories.crud;

import com.reto2.ciclo4.app.entities.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author oacas
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
    //Retorna las ordenes que coincidan con la zona
    @Query("{'salesMan.zone':?0}")
    List<Order> findByZone(final String zone);
    
    //Retorna las ordenes por estado
    @Query("{status:?0}")
    List<Order> findByStatus(final String status);
    
     //Selecciona orden con el Id Maximo o el ultimo Id
    Optional<Order> findTopByOrderByIdDesc();
    
}
