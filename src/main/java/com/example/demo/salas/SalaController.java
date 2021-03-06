package com.example.demo.salas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/salas")
public class SalaController 
{
    @Autowired
    private SalaService salaService;

    @PostMapping("")
    public ResponseEntity<Sala> addSala(@RequestBody Sala salanew) 
    {
        Sala sala = salaService.saveOrUpdateSala(salanew);
        return new ResponseEntity<Sala>(sala, HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Sala> getSalas() 
    {
        return salaService.listAll();
    }
    @GetMapping("/tipo")
    public Iterable<Sala> getTipoSala(@RequestParam(value = "tipoSala") String tipoSala) {
        return salaService.listbytype(tipoSala);
    }
    @GetMapping("/{id}")
    public Sala getSalas(@PathVariable("id") Long id) {
        return salaService.listOne(id);                
    }
    @DeleteMapping("/{id}")
    public void deleteSala(@PathVariable("id") Long id){
        salaService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSala(@RequestBody Sala newsala, @PathVariable("id") Long id){
        Sala sala = salaService.listOne(id);
        if(sala != null ){
            sala.setTipoSala(newsala.getTipoSala());
            sala.setEquipamiento(newsala.getEquipamiento());
            sala.setDisponibilidad(newsala.getDisponibilidad());
            salaService.saveOrUpdateSala(sala);
            return new ResponseEntity<Sala>(sala,HttpStatus.OK);    
        }
        else {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        }
    };

}