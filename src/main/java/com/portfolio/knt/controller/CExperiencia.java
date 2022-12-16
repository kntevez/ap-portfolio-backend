/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.controller;

import com.portfolio.knt.dto.DtoExperiencia;
import com.portfolio.knt.entity.Experiencia;
import com.portfolio.knt.security.controller.Mensaje;
import com.portfolio.knt.service.ISExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://portfolio-knt.web.app", "http://localhost:4200"})
public class CExperiencia {

    @Autowired
    private ISExperiencia isExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = isExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!isExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Experiencia experiencia = isExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!isExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        isExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
        if(StringUtils.isBlank(dtoexp.getLogo()) || StringUtils.isBlank(dtoexp.getEmpresa()) || StringUtils.isBlank(dtoexp.getpDesde()) || 
                StringUtils.isBlank(dtoexp.getpHasta()) || StringUtils.isBlank(dtoexp.getPuesto()) || StringUtils.isBlank(dtoexp.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoexp.getLogo(), dtoexp.getEmpresa(), dtoexp.getpDesde(), dtoexp.getpHasta(), dtoexp.getPuesto(), dtoexp.getDescripcion());
        isExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp) {             
        if (!isExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoexp.getLogo()) || StringUtils.isBlank(dtoexp.getEmpresa()) || StringUtils.isBlank(dtoexp.getpDesde()) || 
                StringUtils.isBlank(dtoexp.getpHasta()) || StringUtils.isBlank(dtoexp.getPuesto()) || StringUtils.isBlank(dtoexp.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = isExperiencia.getOne(id).get();
        
        experiencia.setLogo(dtoexp.getLogo());
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setpDesde(dtoexp.getpDesde());
        experiencia.setpHasta(dtoexp.getpHasta());
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setDescripcion(dtoexp.getDescripcion()); 

        isExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
