package com.portfolio.knt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String logo;
    private String instituto;
    private String pDesde;
    private String pHasta;
    private String estudio;
    @Column(length = 510)
    private String descripcion;

    public Educacion() {
    }

    public Educacion(String logo, String instituto, String pDesde, String pHasta, String estudio, String descripcion) {
        this.logo = logo;
        this.instituto = instituto;
        this.pDesde = pDesde;
        this.pHasta = pHasta;
        this.estudio = estudio;
        this.descripcion = descripcion;
    }

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

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
