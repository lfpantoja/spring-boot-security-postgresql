package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.Casa;
import com.alicuotas.spring.security.postgresql.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CasaController {

    @Autowired
    CasaRepository casaRepository;

    @GetMapping("/allcasa")
    public String allAccess() {
        return "Public Content Casa.";
    }

    @GetMapping("/getallcasa")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Casa>> getAllCasa()
    {
        List<Casa> listaCasa = casaRepository.findAll();
        if(!listaCasa.isEmpty()){
            return ResponseEntity.ok(listaCasa);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/getcasa/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Casa> getCasa(@PathVariable Long id){
        Casa casa = casaRepository.findById(id).orElse(null);
        if(casa != null){
            return ResponseEntity.ok(casa);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addcasa")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Casa> addCasa(@RequestBody Casa casa){
        Casa casaAux = new Casa();

        casaAux.setNumero_casa(casa.getNumero_casa());
        casaAux.setParqueadero_casa(casa.getParqueadero_casa());
        casaAux.setDescripcion_casa(casa.getDescripcion_casa());
        casaAux.setId_tipo_casa_casa(casa.getId_tipo_casa_casa());

        Casa casaAdd = casaRepository.save(casaAux);

        if(casaAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(casaAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updatecasa/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Casa> updateCasa(@PathVariable Long id, @RequestBody Casa casa){
        Casa existeCasa = casaRepository.findById(id).orElse(null);

        if(existeCasa != null){
            existeCasa.setNumero_casa(casa.getNumero_casa());
            existeCasa.setParqueadero_casa(casa.getParqueadero_casa());
            existeCasa.setDescripcion_casa(casa.getDescripcion_casa());
            existeCasa.setId_tipo_casa_casa(casa.getId_tipo_casa_casa());
            return ResponseEntity.ok(casaRepository.save(existeCasa));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletecasa")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Casa> deleteCasa(@RequestBody Casa casa){
        boolean existeCasa = casaRepository.existsById(casa.getId_casa());
        if(existeCasa){
            casaRepository.delete(casa);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
