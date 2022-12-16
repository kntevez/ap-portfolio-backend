package com.portfolio.knt.service;

import com.portfolio.knt.entity.HyS;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.knt.repository.RHyS;
import javax.transaction.Transactional;

@Service
@Transactional
public class SHyS implements ISHyS{
    
    @Autowired
    public RHyS rHyS;
    
    @Override
    public List<HyS> list(){
        return rHyS.findAll();
    }
    
    @Override
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    
    @Override
    public Optional<HyS> getBySkill(String skill){
        return rHyS.findBySkill(skill);
    }
    
    @Override
    public void save(HyS hys){
        rHyS.save(hys);
    }
    
    @Override
    public void delete(int id){
        rHyS.deleteById(id);
    }
    
    @Override
    public boolean existsById(int id){
        return rHyS.existsById(id);
    }
    
    @Override
    public boolean existsBySkill(String skill){
        return rHyS.existsBySkill(skill);
    }
}
