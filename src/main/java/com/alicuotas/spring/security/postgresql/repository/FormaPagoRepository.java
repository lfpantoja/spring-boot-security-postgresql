package com.alicuotas.spring.security.postgresql.repository;

import com.alicuotas.spring.security.postgresql.models.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago, Long> {

}
