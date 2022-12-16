package com.portfolio.knt.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String logo;
    @NotBlank
    private String empresa;
    @NotBlank
    private String pDesde;
    @NotBlank
    private String pHasta;
    @NotBlank
    private String puesto;
    @NotBlank
    private String descripcion;
    
    //Constructores

    public DtoExperiencia() {
    }

    public DtoExperiencia(String logo, String empresa, String pDesde, String pHasta, String puesto, String descripcion) {
        this.logo = logo;
        this.empresa = empresa;
        this.pDesde = pDesde;
        this.pHasta = pHasta;
        this.puesto = puesto;
        this.descripcion = descripcion;
    }
    
    //Getters & Setters

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

