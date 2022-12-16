package com.portfolio.knt.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String logo;
    @NotBlank
    private String instituto;
    @NotBlank
    private String pDesde;
    @NotBlank
    private String pHasta;
    @NotBlank
    private String estudio;
    @NotBlank
    private String descripcion;
    
    public DtoEducacion() {
    }

    public DtoEducacion(String logo, String instituto, String pDesde, String pHasta, String estudio, String descripcion) {
        this.logo = logo;
        this.instituto = instituto;
        this.pDesde = pDesde;
        this.pHasta = pHasta;
        this.estudio = estudio;
        this.descripcion = descripcion;
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