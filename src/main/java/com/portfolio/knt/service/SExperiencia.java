package com.portfolio.knt.service;

import com.portfolio.knt.entity.Experiencia;
import com.portfolio.knt.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia implements ISExperiencia{
    
     @Autowired
     public RExperiencia rExperiencia;
     
     public List<Experiencia> list(){
         return rExperiencia.findAll();
     }
     
     @Override
     public Optional<Experiencia> getOne(int id){
         return rExperiencia.findById(id);
     }
     
     @Override
     public Optional<Experiencia> getByEmpresa(String empresa){
         return rExperiencia.findByEmpresa(empresa);
     }
     
     @Override
     public void save(Experiencia experiencia){
         rExperiencia.save(experiencia);
     }
     
     @Override
     public void delete(int id){
         rExperiencia.deleteById(id);
     }
     
     @Override
     public boolean existsById(int id){
         return rExperiencia.existsById(id);
     }
     
     @Override
     public boolean existsByEmpresa(String empresa){
         return rExperiencia.existsByEmpresa(empresa);
     }
}
