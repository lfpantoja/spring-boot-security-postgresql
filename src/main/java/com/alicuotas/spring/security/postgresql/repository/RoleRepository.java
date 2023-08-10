package com.alicuotas.spring.security.postgresql.repository;

import java.util.Optional;

import com.alicuotas.spring.security.postgresql.models.ERole;
import com.alicuotas.spring.security.postgresql.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
