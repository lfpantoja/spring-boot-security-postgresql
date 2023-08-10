package com.alicuotas.spring.security.postgresql.repository;

import com.alicuotas.spring.security.postgresql.models.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository  extends JpaRepository<Casa, Long> {
}
