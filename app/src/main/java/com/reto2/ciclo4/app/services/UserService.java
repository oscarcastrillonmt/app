/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.ciclo4.app.services;

import com.reto2.ciclo4.app.entities.User;
import com.reto2.ciclo4.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oacas
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository repositorio;
    
    public List<User> listar(){
        return repositorio.listar();
    }
    
    public boolean existeEmail(String email){
        return repositorio.existeEmail(email);
    }
    
    public User autenticarUsuario(String email, String password){
        Optional<User> usuario= repositorio.autenticarUsuario(email, password);
        
        
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return new User();
        }
        
    }
    
 
    
    public User create(User user){
        if(user.getId()==null){
            return user;
        } else{
            Optional<User> e =repositorio.getUser(user.getId());
            
            if(e.isPresent()){
                if(existeEmail(user.getEmail())==true){
                    return user;
                }else{
                    return repositorio.create(user);
                }
                
            }else{
                return repositorio.create(user);
            }
            
        }
        
    }
    
    public User update(User user){
        
        if(user.getId()!=null){
            Optional<User> userDB =repositorio.getUser(user.getId());
        
            if(userDB.isPresent()){
                if(user.getIdentification()!=null){
                    userDB.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userDB.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userDB.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userDB.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userDB.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userDB.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userDB.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userDB.get().setType(user.getType());
                }
                repositorio.update(userDB.get());
                return userDB.get();
            }else{
                return user;
            } 
        }else{
            return user;
        }
        
    }
    
    
    public Optional<User> getUser(int Id){
        return repositorio.getUser(Id);
    }
    
    public boolean delete(Integer id){
        Boolean aBoolean = getUser(id).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}