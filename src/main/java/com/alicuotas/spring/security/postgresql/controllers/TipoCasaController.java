package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.TipoCasa;
import com.alicuotas.spring.security.postgresql.repository.TipoCasaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TipoCasaController {

    @Autowired
    TipoCasaRespository tipoCasaRepository;

    @GetMapping("/alltc")
    public String allAccess() {
        return "Public Content TipoCasa.";
    }

    @GetMapping("/getalltc")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TipoCasa>> getAllTipoCasa()
    {
        List<TipoCasa> listaTipoCasa = tipoCasaRepository.findAll();
        if(!listaTipoCasa.isEmpty()){
            return ResponseEntity.ok(listaTipoCasa);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/gettc/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoCasa> getTipoPropietario(@PathVariable Long id){
        TipoCasa tipoCasa = tipoCasaRepository.findById(id).orElse(null);
        if(tipoCasa != null){
            return ResponseEntity.ok(tipoCasa);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addtc")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoCasa> addTipoCasa(@RequestBody TipoCasa tipoCasa){
        TipoCasa tipoCasaAux = new TipoCasa();
        tipoCasaAux.setDescripcion_tipo_casa(tipoCasa.getDescripcion_tipo_casa());
        tipoCasaAux.setId_tipo_propietario_tipo_casa(tipoCasa.getId_tipo_propietario_tipo_casa());

        TipoCasa tipoCasaAdd = tipoCasaRepository.save(tipoCasaAux);

        if(tipoCasaAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoCasaAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updatetc/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoCasa> updateTipoCasa(@PathVariable Long id, @RequestBody TipoCasa tipoCasa){
        TipoCasa existeTipoCasa = tipoCasaRepository.findById(id).orElse(null);
        if(existeTipoCasa != null){
            existeTipoCasa.setDescripcion_tipo_casa(tipoCasa.getDescripcion_tipo_casa());
            existeTipoCasa.setId_tipo_propietario_tipo_casa(tipoCasa.getId_tipo_propietario_tipo_casa());
            return ResponseEntity.ok(tipoCasaRepository.save(existeTipoCasa));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletetc")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoCasa> deleteTipoCasa(@RequestBody TipoCasa tipoCasa){
        boolean existeTipoCasa = tipoCasaRepository.existsById(tipoCasa.getId_tipo_casa());
        if(existeTipoCasa){
            tipoCasaRepository.delete(tipoCasa);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
