/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.knt.service;

import com.portfolio.knt.entity.Proyectos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author kevin
 */
public interface ISProyectos {
    
    public List<Proyectos> list();
    
    public Optional<Proyectos> getOne(int id);
     
    public Optional<Proyectos> getByNombre(String nombre);
     
    public void save(Proyectos proyectos);
     
    public void delete(int id);
     
    public boolean existsById(int id);
     
    public boolean existsByNombre(String nombre);
}
