/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto2.ciclo4.app.services;

import com.reto2.ciclo4.app.entities.Order;
import com.reto2.ciclo4.app.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oacas
 */

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repositorio;
    
    public List<Order> getAll(){
        return repositorio.getAll();
    }
    
    public Optional<Order> getOrder(int id){
        return repositorio.getOrder(id);
    }
    
    public Order create(Order order){
        
        Optional<Order> orderIdMaximo = repositorio.lastOrderId();
        
        if(order.getId()==null){
           if(!orderIdMaximo.isPresent()){
                order.setId(1);
            }else{
                order.setId(orderIdMaximo.get().getId()+1);
            } 
        }        
        
        Optional<Order> e = repositorio.getOrder(order.getId());

            if(!e.isPresent()){
                return repositorio.create(order);
            }else{
                return order;
            }
    }
    
    
    
    public Order update(Order order){
        return repositorio.update(order);
    }
    
    
    public boolean delete(Integer id){
     Boolean aBoolean = getOrder(id).map(order -> {
            repositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Order> findByZone(String zona){
        return repositorio.findByZone(zona);
    }
}
