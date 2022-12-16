/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.service;

import com.portfolio.knt.entity.Proyectos;
import com.portfolio.knt.repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos implements ISProyectos{
    
     @Autowired
     public RProyectos rProyectos;
     
     public List<Proyectos> list(){
         return rProyectos.findAll();
     }
     
     @Override
     public Optional<Proyectos> getOne(int id){
         return rProyectos.findById(id);
     }
     
     @Override
     public Optional<Proyectos> getByNombre(String nombre){
         return rProyectos.findByNombre(nombre);
     }
     
     @Override
     public void save(Proyectos proyectos){
         rProyectos.save(proyectos);
     }
     
     @Override
     public void delete(int id){
         rProyectos.deleteById(id);
     }
     
     @Override
     public boolean existsById(int id){
         return rProyectos.existsById(id);
     }
     
     @Override
     public boolean existsByNombre(String nombre){
         return rProyectos.existsByNombre(nombre);
     }
}
