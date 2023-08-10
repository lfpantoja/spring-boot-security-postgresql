package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "tipo_concepto")
public class TipoConcepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_concepto;

    @NotBlank
    @Size(max = 50)
    private String descripcion_tipo_concepto;

    public TipoConcepto() {
    }

    public TipoConcepto(Long id_tipo_concepto, String descripcion_tipo_concepto) {
        this.id_tipo_concepto = id_tipo_concepto;
        this.descripcion_tipo_concepto = descripcion_tipo_concepto;
    }

    public Long getId_tipo_concepto() {
        return id_tipo_concepto;
    }

    public void setId_tipo_concepto(Long id_tipo_concepto) {
        this.id_tipo_concepto = id_tipo_concepto;
    }

    public String getDescripcion_tipo_concepto() {
        return descripcion_tipo_concepto;
    }

    public void setDescripcion_tipo_concepto(String descripcion_tipo_concepto) {
        this.descripcion_tipo_concepto = descripcion_tipo_concepto;
    }

    @Override
    public String toString() {
        return "TipoConcepto{" +
                "id_tipo_concepto=" + id_tipo_concepto +
                ", descripcion_tipo_concepto='" + descripcion_tipo_concepto + '\'' +
                '}';
    }
}
