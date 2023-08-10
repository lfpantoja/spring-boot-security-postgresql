package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.TipoPropietario;
import com.alicuotas.spring.security.postgresql.repository.TipoPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TipoPropietarioController {

    @Autowired
    TipoPropietarioRepository tipoPropietarioRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content TipoPropietario.";
    }

    @GetMapping("/getalltp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TipoPropietario>> getAllTipoPropietario()
    {
        List<TipoPropietario> listaTipoPropietario = tipoPropietarioRepository.findAll();
        if(!listaTipoPropietario.isEmpty()){
            return ResponseEntity.ok(listaTipoPropietario);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/gettp/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoPropietario> getTipoPropietario(@PathVariable Long id){
        TipoPropietario tipoPropietario = tipoPropietarioRepository.findById(id).orElse(null);
        if(tipoPropietario != null){
            return ResponseEntity.ok(tipoPropietario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addtp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoPropietario> addTipoPropietario(@RequestBody TipoPropietario tipoPropietario){
        TipoPropietario tipoPropietarioAux = new TipoPropietario();
        tipoPropietarioAux.setDescripcion_tipo_propietario(tipoPropietario.getDescripcion_tipo_propietario());

        TipoPropietario tipoPropietarioAdd = tipoPropietarioRepository.save(tipoPropietarioAux);

        if(tipoPropietarioAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoPropietarioAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updatetp/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoPropietario> updateTipoPropietario(@PathVariable Long id, @RequestBody TipoPropietario tipoPropietario){
        TipoPropietario existeTipoPropietario = tipoPropietarioRepository.findById(id).orElse(null);
        if(existeTipoPropietario != null){
            existeTipoPropietario.setDescripcion_tipo_propietario(tipoPropietario.getDescripcion_tipo_propietario());
            return ResponseEntity.ok(tipoPropietarioRepository.save(existeTipoPropietario));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletetp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoPropietario> deleteTipoPropietario(@RequestBody TipoPropietario tipoPropietario){
        boolean existeTipoPropietario = tipoPropietarioRepository.existsById(tipoPropietario.getId_tipo_propietario());
        if(existeTipoPropietario){
            tipoPropietarioRepository.delete(tipoPropietario);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
