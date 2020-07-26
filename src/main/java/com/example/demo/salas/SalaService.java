package com.example.demo.salas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService 
{
    @Autowired
    private SalaRepository salaRepository;
    
    public Sala saveOrUpdateSala(Sala sala)
    {
        return salaRepository.save(sala);
    }

    public Iterable<Sala> listAll()
    {
        return salaRepository.findAll();
    }
    public Sala listOne(Long id)
    {
        Sala result = salaRepository.findById(id).get();
        return result;
    }
    public Iterable<Sala> listbytype(String type)
    {
        Iterable<Sala> result = salaRepository.findByTipoSala(type);
        return result;
    }
}