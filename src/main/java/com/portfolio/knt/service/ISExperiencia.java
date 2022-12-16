package com.portfolio.knt.service;

import com.portfolio.knt.entity.Experiencia;
import java.util.List;
import java.util.Optional;

public interface ISExperiencia {
    
    public List<Experiencia> list();
    
    public Optional<Experiencia> getOne(int id);
     
    public Optional<Experiencia> getByEmpresa(String empresa);
     
    public void save(Experiencia experiencia);
     
    public void delete(int id);
     
    public boolean existsById(int id);
     
    public boolean existsByEmpresa(String empresa);
}
