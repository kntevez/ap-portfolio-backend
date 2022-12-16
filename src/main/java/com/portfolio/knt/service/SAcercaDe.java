package com.portfolio.knt.service;

import com.portfolio.knt.entity.AcercaDe;
import com.portfolio.knt.repository.RAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercaDe implements ISAcercaDe {
    
     @Autowired
     public RAcercaDe rAcercaDe;
     
     @Override
     public List<AcercaDe> list(){
         return rAcercaDe.findAll();
     }
     
     @Override
     public Optional<AcercaDe> getOne(int id){
         return rAcercaDe.findById(id);
     }
     
     @Override
     public Optional<AcercaDe> getByNombre(String nombre){
         return rAcercaDe.findByNombre(nombre);
     }

     @Override
     public void save(AcercaDe acercaDe){
         rAcercaDe.save(acercaDe);
     }
     
     @Override
     public void delete(int id){
         rAcercaDe.deleteById(id);
     }
     
     @Override
     public boolean existsById(int id){
         return rAcercaDe.existsById(id);
     }
     
    @Override
     public boolean existsByNombre(String nombre){
         return rAcercaDe.existsByNombre(nombre);
     }
}
