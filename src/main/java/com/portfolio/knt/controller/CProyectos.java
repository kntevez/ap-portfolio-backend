/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.controller;

import com.portfolio.knt.dto.DtoProyectos;
import com.portfolio.knt.entity.Proyectos;
import com.portfolio.knt.security.controller.Mensaje;
import com.portfolio.knt.service.ISProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"https://portfolio-knt.web.app", "http://localhost:4200"})
public class CProyectos {

    @Autowired
    private ISProyectos isProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = isProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!isProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        
        Proyectos proyectos = isProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!isProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        isProyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproyecto) {
        if(StringUtils.isBlank(dtoproyecto.getCaptura()) || StringUtils.isBlank(dtoproyecto.getNombre()) || StringUtils.isBlank(dtoproyecto.getLink()) || 
                StringUtils.isBlank(dtoproyecto.getCreacion()) || StringUtils.isBlank(dtoproyecto.getLenguajes()) || StringUtils.isBlank(dtoproyecto.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoproyecto.getCaptura(), dtoproyecto.getNombre(), dtoproyecto.getLink(), dtoproyecto.getCreacion(), dtoproyecto.getLenguajes(), dtoproyecto.getDescripcion());
        isProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyectos agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproyecto) {
        //Validamos si existe el ID
        if (!isProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(!isProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getCaptura()) || StringUtils.isBlank(dtoproyecto.getNombre()) || StringUtils.isBlank(dtoproyecto.getLink()) || 
                StringUtils.isBlank(dtoproyecto.getCreacion()) || StringUtils.isBlank(dtoproyecto.getLenguajes()) || StringUtils.isBlank(dtoproyecto.getDescripcion())){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = isProyectos.getOne(id).get();
        
        proyectos.setCaptura(dtoproyecto.getCaptura());
        proyectos.setNombre(dtoproyecto.getNombre());
        proyectos.setLink(dtoproyecto.getLink());
        proyectos.setCreacion(dtoproyecto.getCreacion());
        proyectos.setLenguajes(dtoproyecto.getLenguajes());
        proyectos.setDescripcion(dtoproyecto.getDescripcion()); 

        isProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);

    }
}
