package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "tipo_casa")
public class TipoCasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_casa;

    @NotBlank
    @Size(max = 200)
    private String descripcion_tipo_casa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_propietario_tipo_casa")
    private TipoPropietario id_tipo_propietario_tipo_casa;

    public TipoCasa() {
    }

    public TipoCasa(Long id_tipo_casa, String descripcion_tipo_casa, TipoPropietario id_tipo_propietario_tipo_casa) {
        this.id_tipo_casa = id_tipo_casa;
        this.descripcion_tipo_casa = descripcion_tipo_casa;
        this.id_tipo_propietario_tipo_casa = id_tipo_propietario_tipo_casa;
    }

    public Long getId_tipo_casa() {
        return id_tipo_casa;
    }

    public void setId_tipo_casa(Long id_tipo_casa) {
        this.id_tipo_casa = id_tipo_casa;
    }

    public String getDescripcion_tipo_casa() {
        return descripcion_tipo_casa;
    }

    public void setDescripcion_tipo_casa(String descripcion_tipo_casa) {
        this.descripcion_tipo_casa = descripcion_tipo_casa;
    }

    public TipoPropietario getId_tipo_propietario_tipo_casa() {
        return id_tipo_propietario_tipo_casa;
    }

    public void setId_tipo_propietario_tipo_casa(TipoPropietario id_tipo_propietario_tipo_casa) {
        this.id_tipo_propietario_tipo_casa = id_tipo_propietario_tipo_casa;
    }

    @Override
    public String toString() {
        return "TipoCasa{" +
                "id_tipo_casa=" + id_tipo_casa +
                ", descripcion_tipo_casa='" + descripcion_tipo_casa + '\'' +
                ", id_tipo_propietario_tipo_casa=" + id_tipo_propietario_tipo_casa +
                '}';
    }

}
