/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto2.ciclo4.app.repositories;

import com.reto2.ciclo4.app.entities.Order;
import com.reto2.ciclo4.app.repositories.crud.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository crudRepository;
    
    @Autowired 
    private MongoTemplate mongoTemplate;
    
    public List<Order> getAll(){
        return (List<Order>) crudRepository.findAll();
    }
    
    public Optional<Order> getOrder(int id){
        return crudRepository.findById(id);
    }
    
    public Order create(Order order){
        return crudRepository.save(order);
    }
    
    public Order update(Order order){
        return crudRepository.save(order);
    }
    
    public void delete(Order order){
        crudRepository.delete(order);
    }
    
    public List<Order> findByZone(String zona){
        return crudRepository.findByZone(zona);
    }
    
    public Optional<Order> lastOrderId(){
        return crudRepository.findTopByOrderByIdDesc();
        
    }
    
    
   
    public List<Order> ordersSalesManByID(Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
    
   
    public List<Order> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(dateCriteria);
        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }   
    
    
    
    
    
    
    
}
