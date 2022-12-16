package com.portfolio.knt.service;

import com.portfolio.knt.entity.Educacion;
import com.portfolio.knt.repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion implements ISEducacion{
    
    @Autowired
    public REducacion rEducacion;
    
    @Override
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    @Override
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    @Override
    public Optional<Educacion> getByInstituto(String instituto){
        return rEducacion.findByInstituto(instituto);
    }
    
    @Override
    public void save(Educacion educacion){
        rEducacion.save(educacion);
    }
    
    @Override
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    @Override
    public boolean existsByInstituto(String instituto){
        return rEducacion.existsByInstituto(instituto);
    }
}
