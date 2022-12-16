package com.portfolio.knt.controller;

import com.portfolio.knt.dto.DtoAcercaDe;
import com.portfolio.knt.entity.AcercaDe;
import com.portfolio.knt.security.controller.Mensaje;
import com.portfolio.knt.service.ISAcercaDe;
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
@RequestMapping("/acercaDe")
@CrossOrigin(origins = {"https://portfolio-knt.web.app", "http://localhost:4200"})
public class CAcercaDe {
    
    @Autowired
    private ISAcercaDe isAcercaDe;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list(){
        List<AcercaDe> list = isAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id")int id){
        if(!isAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = isAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!isAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        isAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("AcercaDe eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAcercaDe dtoacercaDe){
        
        if(StringUtils.isBlank(dtoacercaDe.getFoto()) || StringUtils.isBlank(dtoacercaDe.getNombre()) || 
                StringUtils.isBlank(dtoacercaDe.getTitulo()) || StringUtils.isBlank(dtoacercaDe.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = new AcercaDe(
                dtoacercaDe.getFoto(), dtoacercaDe.getNombre(), dtoacercaDe.getTitulo(), dtoacercaDe.getDescripcion()
            );
        isAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("AcercaDe creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoAcercaDe dtoacercaDe){
        if(!isAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoacercaDe.getFoto()) || StringUtils.isBlank(dtoacercaDe.getNombre()) || 
                StringUtils.isBlank(dtoacercaDe.getTitulo()) || StringUtils.isBlank(dtoacercaDe.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = isAcercaDe.getOne(id).get();
        
        acercaDe.setFoto(dtoacercaDe.getFoto());
        acercaDe.setNombre(dtoacercaDe.getNombre());
        acercaDe.setTitulo(dtoacercaDe.getTitulo());
        acercaDe.setDescripcion(dtoacercaDe.getDescripcion());
        
        isAcercaDe.save(acercaDe);
        
        return new ResponseEntity(new Mensaje("AcercaDe actualizada"), HttpStatus.OK);
    }
}
