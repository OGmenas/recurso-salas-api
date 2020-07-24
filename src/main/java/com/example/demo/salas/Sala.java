package com.example.demo.salas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tipoSala;
    private String equipamiento;
    private Boolean disponibilidad;

    public Sala()
    {
        
    }
    public Long getId() 
    {
        return id;
    }
    public void setId(Long id) 
    {
        this.id = id;    
    }
    public String getEquipamiento()
    {
        return equipamiento;
    }
    public void setEquipamiento(String equipamiento) 
    {
        this.equipamiento = equipamiento;    
    }
    public String getTipoSala()
    {
        return tipoSala;
    }
    public void setTipoSala(String tipo) 
    {
        this.tipoSala =tipo;    
    }
    public Boolean getDisponibilidad() 
    {
        return disponibilidad;    
    }
    public void setDisponibilidad(Boolean disponibilidad) 
    {
        this.disponibilidad = disponibilidad;    
    } 
}