/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.knt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String logo;
    private String empresa;
    private String pDesde;
    private String pHasta;
    private String puesto;
    @Column(length = 510)
    private String descripcion;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String logo, String empresa, String pDesde, String pHasta, String puesto, String descripcion) {
        this.logo = logo;
        this.empresa = empresa;
        this.pDesde = pDesde;
        this.pHasta = pHasta;
        this.puesto = puesto;
        this.descripcion = descripcion;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getpDesde() {
        return pDesde;
    }

    public void setpDesde(String pDesde) {
        this.pDesde = pDesde;
    }
    
    public String getpHasta() {
        return pHasta;
    }

    public void setpHasta(String pHasta) {
        this.pHasta = pHasta;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
