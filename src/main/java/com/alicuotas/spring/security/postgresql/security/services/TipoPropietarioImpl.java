package com.alicuotas.spring.security.postgresql.security.services;

import com.alicuotas.spring.security.postgresql.models.TipoPropietario;
import com.alicuotas.spring.security.postgresql.repository.TipoPropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoPropietarioImpl {

    private final TipoPropietarioRepository tipoPropietarioRepository;

    @Autowired
    public TipoPropietarioImpl (TipoPropietarioRepository tipoPropietarioRepository){
        this.tipoPropietarioRepository = tipoPropietarioRepository;
    }

    public void saveTipoPropietario(TipoPropietario tipoPropietario){
        tipoPropietarioRepository.save(tipoPropietario);
    }

    public TipoPropietario getTipoPropietarioById(Long id){
        return tipoPropietarioRepository.findById(id).orElse(null);
    }

    public void deleteTipoPropietario(TipoPropietario tipoPropietario){
        tipoPropietarioRepository.delete(tipoPropietario);
    }

    public List<TipoPropietario> getAllTipoPropietario(){
        return tipoPropietarioRepository.findAll();
    }

}
