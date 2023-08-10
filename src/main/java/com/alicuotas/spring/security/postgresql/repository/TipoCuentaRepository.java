package com.alicuotas.spring.security.postgresql.repository;

import com.alicuotas.spring.security.postgresql.models.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
}
