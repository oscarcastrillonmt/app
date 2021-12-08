/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.repositories;

import com.reto2.ciclo4.app.repositories.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oacas
 */
@Repository
public class ProductoRepository {
    
    @Autowired
    private ProductoCrudRepository repositorioCrud;
    
}
