package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "entidad_bancaria")
public class EntidadBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entidad_bancaria;

    @NotBlank
    @Size(max = 100)
    private String descripcion_entidad_bancaria;

    public EntidadBancaria() {
    }

    public EntidadBancaria(Long id_entidad_bancaria, String descripcion_entidad_bancaria) {
        this.id_entidad_bancaria = id_entidad_bancaria;
        this.descripcion_entidad_bancaria = descripcion_entidad_bancaria;
    }

    public Long getId_entidad_bancaria() {
        return id_entidad_bancaria;
    }

    public void setId_entidad_bancaria(Long id_entidad_bancaria) {
        this.id_entidad_bancaria = id_entidad_bancaria;
    }

    public String getDescripcion_entidad_bancaria() {
        return descripcion_entidad_bancaria;
    }

    public void setDescripcion_entidad_bancaria(String descripcion_entidad_bancaria) {
        this.descripcion_entidad_bancaria = descripcion_entidad_bancaria;
    }

    @Override
    public String toString() {
        return "EntidadBancaria{" +
                "id_entidad_bancaria=" + id_entidad_bancaria +
                ", descripcion_entidad_bancaria='" + descripcion_entidad_bancaria + '\'' +
                '}';
    }
}
