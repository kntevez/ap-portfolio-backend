package com.portfolio.knt.controller;

import com.portfolio.knt.dto.DtoHyS;
import com.portfolio.knt.entity.HyS;
import com.portfolio.knt.security.controller.Mensaje;
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
import com.portfolio.knt.service.ISHyS;

@RestController
@RequestMapping("/hys")
@CrossOrigin(origins = {"https://portfolio-knt.web.app", "http://localhost:4200"})
public class CHyS {
    
    @Autowired
    private ISHyS isHyS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list(){
        List<HyS> list = isHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id")int id){
        if(!isHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        HyS hys = isHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!isHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        isHyS.delete(id);
        return new ResponseEntity(new Mensaje("HyS eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHyS dtohys){
        if(StringUtils.isBlank(dtohys.getSeccion()) || StringUtils.isBlank(dtohys.getSkill()) || StringUtils.isBlank(Integer.toString(dtohys.getNivel()))){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        HyS hys = new HyS(dtohys.getSeccion(), dtohys.getSkill(), dtohys.getNivel());
        isHyS.save(hys);
        return new ResponseEntity(new Mensaje("HyS creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHyS dtohys){
        
        if(!isHyS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(StringUtils.isBlank(dtohys.getSeccion()) || StringUtils.isBlank(dtohys.getSkill()) || StringUtils.isBlank(Integer.toString(dtohys.getNivel()))){
            return new ResponseEntity(new Mensaje("Todos los campos son obligatorios"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = isHyS.getOne(id).get();
        
        hys.setSeccion(dtohys.getSeccion());
        hys.setSkill(dtohys.getSkill());
        hys.setNivel(dtohys.getNivel());
        isHyS.save(hys);
        
        return new ResponseEntity(new Mensaje("HyS actualizada"), HttpStatus.OK);
    }
}
