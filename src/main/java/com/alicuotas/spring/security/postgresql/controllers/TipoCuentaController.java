package com.alicuotas.spring.security.postgresql.controllers;

import com.alicuotas.spring.security.postgresql.models.TipoCuenta;
import com.alicuotas.spring.security.postgresql.repository.TipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TipoCuentaController {

    @Autowired
    TipoCuentaRepository tipoCuentaRepository;

    @GetMapping("/alltipocuenta")
    public String allAccess() {
        return "Public Content TipoCuenta.";
    }

    @GetMapping("/getalltipocuenta")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TipoCuenta>> getAllTipoCuenta()
    {
        List<TipoCuenta> listaTipoCuenta = tipoCuentaRepository.findAll();
        if(!listaTipoCuenta.isEmpty()){
            return ResponseEntity.ok(listaTipoCuenta);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }


}
