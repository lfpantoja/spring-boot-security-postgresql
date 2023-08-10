package com.alicuotas.spring.security.postgresql.repository;

import com.alicuotas.spring.security.postgresql.models.TipoCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCasaRespository extends JpaRepository<TipoCasa, Long> {
}
