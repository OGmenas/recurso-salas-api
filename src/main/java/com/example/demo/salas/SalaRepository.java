package com.example.demo.salas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long>
{
    Iterable<Sala> findByTipoSala(String tipoSala);
}
