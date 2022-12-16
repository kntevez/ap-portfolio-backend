package com.portfolio.knt.dto;

import javax.validation.constraints.NotBlank;

public class DtoHyS {
    @NotBlank
    private String seccion;
    @NotBlank
    private String skill;
    @NotBlank
    private int nivel;
    
    public DtoHyS() {
    }

    public DtoHyS(String seccion, String skill, int nivel) {
        this.seccion = seccion;
        this.skill = skill;
        this.nivel = nivel;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
