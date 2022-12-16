package com.portfolio.knt.repository;

import com.portfolio.knt.entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer> {
    public Optional<AcercaDe> findByNombre (String nombre);
    public boolean existsByNombre(String nombre);
}
