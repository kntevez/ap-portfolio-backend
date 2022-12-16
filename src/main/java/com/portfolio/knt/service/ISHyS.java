package com.portfolio.knt.service;

import com.portfolio.knt.entity.HyS;
import java.util.List;
import java.util.Optional;

public interface ISHyS {
         
    public List<HyS> list();
    
    public Optional<HyS> getOne(int id);
    
    public Optional<HyS> getBySkill(String skill);
    
    public void save(HyS hys);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsBySkill(String skill);
    
}
