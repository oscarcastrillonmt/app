package com.reto2.ciclo4.app;

import com.reto2.ciclo4.app.entities.User;
import com.reto2.ciclo4.app.repositories.crud.UserCrudRepository;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication /*implements CommandLineRunner*/{
    
    @Autowired
    private UserCrudRepository userRepo;

    public static void main(String[] args) {
            SpringApplication.run(AppApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        userRepo.deleteAll();
//        
//        userRepo.saveAll(asList(
//                new User (1,"50502020","Juana Lopez", "Cra 19 No 4-32", "313313313", "juanalopez@gmail.com", "Demo123", "Zona 1", "ADM"),
//                new User (2,"50502021","Juan Lopez", "Cra 19 No 4-32", "313413313", "juanlopez@gmail.com", "Demo123", "Zona 1", "COOR"),
//                new User (3,"502022","Andres Carrasco", "Cra 19 No 4-32", "313853313", "andrescarrasco@gmail.com", "Demo123", "Zona 1", "ASE"),
//                new User (4,"505023","Diego Forero", "Cra 19 No 4-32", "313313513", "diegoforero@gmail.com", "Demo123", "Zona 1", "ASE")
//                
//        ));
//        
//        System.out.println("listado de Usuarios");
//        userRepo.findAll().forEach(System.out::println);
//        
//        Optional<User> usuario= userRepo.findByEmail("juanalopez@gmail.com");
//        
//        if(usuario.isPresent()){
//            System.out.println("Datos del Usuario "+ usuario.get());
//        }
//        
//        Optional<User> usuarioPassword= userRepo.findByEmailAndPassword("juanalopez@gmail.com", "Demo123");
//        
//        if(usuarioPassword.isPresent()){
//            System.out.println("Datos del Usuario "+ usuarioPassword.get());
//        }
//    }
}
