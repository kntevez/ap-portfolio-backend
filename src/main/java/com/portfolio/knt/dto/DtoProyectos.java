/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author kevin
 */
public class DtoProyectos {
    @NotBlank
    private String captura;
    @NotBlank
    private String nombre;
    @NotBlank
    private String link;
    @NotBlank
    private String creacion;
    @NotBlank
    private String lenguajes;
    @NotBlank
    private String descripcion;
    
    //Constructores

    public DtoProyectos() {
    }

    public DtoProyectos(String captura, String nombre, String link, String creacion, String lenguajes, String descripcion) {
        this.captura = captura;
        this.nombre = nombre;
        this.link = link;
        this.creacion = creacion;
        this.lenguajes = lenguajes;
        this.descripcion = descripcion;
    }
    
    //Getters & Setters

    public String getCaptura() {
        return captura;
    }

    public void setCaptura(String captura) {
        this.captura = captura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
