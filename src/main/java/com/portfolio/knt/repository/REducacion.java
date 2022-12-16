package com.portfolio.knt.repository;

import com.portfolio.knt.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByInstituto(String instituto);
    public boolean existsByInstituto(String instituto);
}
