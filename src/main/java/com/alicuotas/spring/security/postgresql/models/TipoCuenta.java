package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "tipo_cuenta")
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_cuenta;

    @NotBlank
    @Size(max = 100)
    private String descripcion_tipo_cuenta;

    public TipoCuenta() {
    }

    public TipoCuenta(Long id_tipo_cuenta, String descripcion_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion_tipo_cuenta = descripcion_tipo_cuenta;
    }

    public TipoCuenta(String descripcion_tipo_cuenta) {
        this.descripcion_tipo_cuenta = descripcion_tipo_cuenta;
    }

    public Long getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(Long id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public String getDescripcion_tipo_cuenta() {
        return descripcion_tipo_cuenta;
    }

    public void setDescripcion_tipo_cuenta(String descripcion_tipo_cuenta) {
        this.descripcion_tipo_cuenta = descripcion_tipo_cuenta;
    }

    @Override
    public String toString() {
        return "TipoCuenta{" +
                "id_tipo_cuenta=" + id_tipo_cuenta +
                ", descripcion_tipo_cuenta='" + descripcion_tipo_cuenta + '\'' +
                '}';
    }
}
