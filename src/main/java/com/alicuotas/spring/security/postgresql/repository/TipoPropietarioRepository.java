package com.alicuotas.spring.security.postgresql.repository;

import com.alicuotas.spring.security.postgresql.models.TipoPropietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPropietarioRepository extends JpaRepository<TipoPropietario, Long> {

}
