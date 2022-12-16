/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.dto;

import javax.validation.constraints.NotBlank;

public class DtoAcercaDe {
    @NotBlank
    private String foto;
    @NotBlank
    private String nombre;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    
    //Constructores

    public DtoAcercaDe() {
    }

    public DtoAcercaDe(String foto, String nombre, String titulo, String descripcion) {
        this.foto = foto;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    //Getters & Setters

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

