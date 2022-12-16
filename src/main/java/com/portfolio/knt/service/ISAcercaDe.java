package com.portfolio.knt.service;

import com.portfolio.knt.entity.AcercaDe;
import java.util.List;
import java.util.Optional;

public interface ISAcercaDe {

    public List<AcercaDe> list();

    public Optional<AcercaDe> getOne(int id);

    public Optional<AcercaDe> getByNombre(String nombre);

    public void save(AcercaDe acercaDe);

    public void delete(int id);

    public boolean existsById(int id);

    public boolean existsByNombre(String nombre);
}
