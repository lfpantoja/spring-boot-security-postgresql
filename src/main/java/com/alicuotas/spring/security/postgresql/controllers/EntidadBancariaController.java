package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.EntidadBancaria;
import com.alicuotas.spring.security.postgresql.repository.EntidadBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaRepository entidadBancariaRepository;

    @GetMapping("/allentidadbancaria")
    public String allAccess() {
        return "Public Content EntidadBancaria.";
    }

    @GetMapping("/getallentidadbancaria")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<EntidadBancaria>> getAllEntidadBancaria()
    {
        List<EntidadBancaria> listaEntidadBancaria = entidadBancariaRepository.findAll();
        if(!listaEntidadBancaria.isEmpty()){
            return ResponseEntity.ok(listaEntidadBancaria);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/getentidadbancaria/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<EntidadBancaria> getEntidadBancaria(@PathVariable Long id){
        EntidadBancaria entidadBancaria = entidadBancariaRepository.findById(id).orElse(null);
        if(entidadBancaria != null){
            return ResponseEntity.ok(entidadBancaria);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addentidadbancaria")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<EntidadBancaria> addEntidadBancaria(@RequestBody EntidadBancaria entidadBancaria){
        EntidadBancaria entidadBancariaAux = new EntidadBancaria();
        entidadBancariaAux.setDescripcion_entidad_bancaria(entidadBancaria.getDescripcion_entidad_bancaria());

        EntidadBancaria entidadBancariaAdd = entidadBancariaRepository.save(entidadBancariaAux);

        if(entidadBancariaAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(entidadBancariaAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateentidadbancaria/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<EntidadBancaria> updateEntidadBancaria(@PathVariable Long id, @RequestBody EntidadBancaria entidadBancaria){
        EntidadBancaria existeEntidadBancaria = entidadBancariaRepository.findById(id).orElse(null);
        if(existeEntidadBancaria != null){
            existeEntidadBancaria.setDescripcion_entidad_bancaria(entidadBancaria.getDescripcion_entidad_bancaria());
            return ResponseEntity.ok(entidadBancariaRepository.save(existeEntidadBancaria));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deleteentidadbancaria")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<EntidadBancaria> deleteEntidadBancaria(@RequestBody EntidadBancaria entidadBancaria){
        boolean existeEntidadBancaria = entidadBancariaRepository.existsById(entidadBancaria.getId_entidad_bancaria());
        if(existeEntidadBancaria){
            entidadBancariaRepository.delete(entidadBancaria);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
