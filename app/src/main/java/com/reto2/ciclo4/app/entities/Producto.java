/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author oacas
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="producto")
public class Producto {
    
    @Id
    private String id;
    private String nombre_producto;
    private int precio;
    private String categoria;
    private int stock;
    private String descripcion;
    
}
