package com.portfolio.knt.service;

import com.portfolio.knt.entity.Educacion;
import java.util.List;
import java.util.Optional;

public interface ISEducacion {
     
    public List<Educacion> list();
    
    public Optional<Educacion> getOne(int id);
    
    public Optional<Educacion> getByInstituto(String instituto);
    
    public void save(Educacion educacion);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByInstituto(String instituto);
     
}
