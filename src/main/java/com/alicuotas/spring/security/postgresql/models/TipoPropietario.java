package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "tipo_propietario")
public class TipoPropietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_propietario;

    @NotBlank
    @Size(max = 20)
    private String descripcion_tipo_propietario;

    public TipoPropietario() {
    }

    public TipoPropietario(Long id_tipo_propietario, String descripcion_tipo_propietario) {
        this.id_tipo_propietario = id_tipo_propietario;
        this.descripcion_tipo_propietario = descripcion_tipo_propietario;
    }

    public Long getId_tipo_propietario() {
        return id_tipo_propietario;
    }

    public void setId_tipo_propietario(Long id_tipo_propietario) {
        this.id_tipo_propietario = id_tipo_propietario;
    }

    public String getDescripcion_tipo_propietario() {
        return descripcion_tipo_propietario;
    }

    public void setDescripcion_tipo_propietario(String descripcion_tipo_propietario) {
        this.descripcion_tipo_propietario = descripcion_tipo_propietario;
    }

    @Override
    public String toString() {
        return "TipoPropietario{" +
                "id_tipo_propietario=" + id_tipo_propietario +
                ", descripcion_tipo_propietario='" + descripcion_tipo_propietario + '\'' +
                '}';
    }

}
