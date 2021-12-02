/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.services;

import com.reto2.ciclo4.app.entities.Producto;
import com.reto2.ciclo4.app.repositories.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oacas
 */

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    public List<Producto> getProductos(){
        return repository.findAll();
    }
    
    public Producto saveProducto(Producto producto){
        return repository.save(producto);
    }
    
    public Producto getProductoId(String id){
        return repository.findById(id).orElse(null);
    }
    
    
    public Producto updateProducto(Producto producto){
        Producto producto_anterior=getProductoId(producto.getId());
        
        producto_anterior.setNombre_producto(producto.getNombre_producto());
        producto_anterior.setPrecio(producto.getPrecio());
        producto_anterior.setCategoria(producto.getCategoria());
        producto_anterior.setStock(producto.getStock());
        producto_anterior.setDescripcion(producto.getDescripcion());
        
        return repository.save(producto_anterior);
    }
    
    public void deleteProducto(String id){
        repository.deleteById(id);
    }
    
}
