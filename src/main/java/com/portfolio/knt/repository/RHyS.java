package com.portfolio.knt.repository;

import com.portfolio.knt.entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHyS extends JpaRepository<HyS, Integer>{
    public Optional<HyS> findBySkill(String skill);
    public boolean existsBySkill(String skill);
}