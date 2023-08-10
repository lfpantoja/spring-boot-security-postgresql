package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.TipoConcepto;
import com.alicuotas.spring.security.postgresql.repository.TipoConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TipoConceptoController {

    @Autowired
    TipoConceptoRepository tipoConceptoRepository;

    @GetMapping("/alltcp")
    public String allAccess() {
        return "Public Content TipoConcepto.";
    }

    @GetMapping("/getalltcp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TipoConcepto>> getAllTipoConcepto()
    {
        List<TipoConcepto> listaTipoConcepto = tipoConceptoRepository.findAll();
        if(!listaTipoConcepto.isEmpty()){
            return ResponseEntity.ok(listaTipoConcepto);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/gettcp/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoConcepto> getTipoConcepto(@PathVariable Long id){
        TipoConcepto tipoConcepto = tipoConceptoRepository.findById(id).orElse(null);
        if(tipoConcepto != null){
            return ResponseEntity.ok(tipoConcepto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addtcp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoConcepto> addTipoConcepto(@RequestBody TipoConcepto tipoConcepto){
        TipoConcepto tipoConceptoAux = new TipoConcepto();
        tipoConceptoAux.setDescripcion_tipo_concepto(tipoConcepto.getDescripcion_tipo_concepto());

        TipoConcepto tipoConceptoAdd = tipoConceptoRepository.save(tipoConceptoAux);

        if(tipoConceptoAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoConceptoAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updatetcp/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoConcepto> updateTipoConcepto(@PathVariable Long id, @RequestBody TipoConcepto tipoConcepto){
        TipoConcepto existeTipoConcepto = tipoConceptoRepository.findById(id).orElse(null);
        if(existeTipoConcepto != null){
            existeTipoConcepto.setDescripcion_tipo_concepto(tipoConcepto.getDescripcion_tipo_concepto());
            return ResponseEntity.ok(tipoConceptoRepository.save(existeTipoConcepto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletetcp")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TipoConcepto> deleteTipoConcepto(@RequestBody TipoConcepto tipoConcepto){
        boolean existeTipoConcepto = tipoConceptoRepository.existsById(tipoConcepto.getId_tipo_concepto());
        if(existeTipoConcepto){
            tipoConceptoRepository.delete(tipoConcepto);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
