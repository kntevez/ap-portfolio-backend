package com.portfolio.knt.controller;

import com.portfolio.knt.dto.DtoEducacion;
import com.portfolio.knt.entity.Educacion;
import com.portfolio.knt.security.controller.Mensaje;
import com.portfolio.knt.service.ISEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://portfolio-knt.web.app", "http://localhost:4200"})
public class CEducacion {
    
    @Autowired
    private ISEducacion isEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = isEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!isEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = isEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!isEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        isEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getLogo()) || StringUtils.isBlank(dtoeducacion.getInstituto()) || StringUtils.isBlank(dtoeducacion.getpDesde()) || 
                StringUtils.isBlank(dtoeducacion.getpHasta()) || StringUtils.isBlank(dtoeducacion.getEstudio()) || StringUtils.isBlank(dtoeducacion.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoeducacion.getLogo(), dtoeducacion.getInstituto(), dtoeducacion.getpDesde(), dtoeducacion.getpHasta(), dtoeducacion.getEstudio(), dtoeducacion.getDescripcion());
        isEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoeducacion){
        
        if(!isEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getLogo()) || StringUtils.isBlank(dtoeducacion.getInstituto()) || StringUtils.isBlank(dtoeducacion.getpDesde()) || 
                StringUtils.isBlank(dtoeducacion.getpHasta()) || StringUtils.isBlank(dtoeducacion.getEstudio()) || StringUtils.isBlank(dtoeducacion.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = isEducacion.getOne(id).get();
        
        educacion.setLogo(dtoeducacion.getLogo());
        educacion.setInstituto(dtoeducacion.getInstituto());
        educacion.setpDesde(dtoeducacion.getpDesde());
        educacion.setpHasta(dtoeducacion.getpHasta());
        educacion.setEstudio(dtoeducacion.getEstudio());
        educacion.setDescripcion(dtoeducacion.getDescripcion()); 
        
        isEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
