package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.FormaPago;
import com.alicuotas.spring.security.postgresql.repository.FormaPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class FormaPagoController {

    @Autowired
    FormaPagoRepository formaPagoRepository;

    @GetMapping("/allformapago")
    public String allAccess() {
        return "Public Content FormaPago.";
    }

    @GetMapping("/getallformapago")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<FormaPago>> getAllFormaPago()
    {
        List<FormaPago> listaFormaPago = formaPagoRepository.findAll();
        if(!listaFormaPago.isEmpty()){
            return ResponseEntity.ok(listaFormaPago);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/getformapago/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<FormaPago> getFormaPago(@PathVariable Long id){
        FormaPago formaPago = formaPagoRepository.findById(id).orElse(null);
        if(formaPago != null){
            return ResponseEntity.ok(formaPago);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addformapago")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<FormaPago> addFormaPago(@RequestBody FormaPago formaPago){
        FormaPago formaPagoAux = new FormaPago();
        formaPagoAux.setDescripcion_forma_pago(formaPago.getDescripcion_forma_pago());
        formaPagoAux.setNumero_forma_pago(formaPago.getNumero_forma_pago());
        formaPagoAux.setId_entidad_bancaria_forma_pago(formaPago.getId_entidad_bancaria_forma_pago());

        FormaPago formaPagoAdd = formaPagoRepository.save(formaPagoAux);

        if(formaPagoAdd != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(formaPagoAdd);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateformapago/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<FormaPago> updateFormaPago(@PathVariable Long id, @RequestBody FormaPago formaPago){
        FormaPago existeFormaPago = formaPagoRepository.findById(id).orElse(null);

        if(existeFormaPago != null){
            existeFormaPago.setDescripcion_forma_pago(formaPago.getDescripcion_forma_pago());
            existeFormaPago.setNumero_forma_pago(formaPago.getNumero_forma_pago());
            existeFormaPago.setId_entidad_bancaria_forma_pago(formaPago.getId_entidad_bancaria_forma_pago());
            return ResponseEntity.ok(formaPagoRepository.save(existeFormaPago));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deleteformapago")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<FormaPago> deleteFormaPago(@RequestBody FormaPago formaPago){
        boolean existeFormaPago = formaPagoRepository.existsById(formaPago.getId_forma_pago());

        if(existeFormaPago){
            formaPagoRepository.delete(formaPago);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
