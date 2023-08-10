package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casa;

    @NotBlank
    @Size(max = 25)
    private String numero_casa;

    private Integer parqueadero_casa;

    @NotBlank
    @Size(max = 255)
    private String descripcion_casa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_casa_casa")
    private TipoCasa id_tipo_casa_casa;

    public Casa() {
    }

    public Casa(Long id_casa, String numero_casa, Integer parqueadero_casa, String descripcion_casa, TipoCasa id_tipo_casa_casa) {
        this.id_casa = id_casa;
        this.numero_casa = numero_casa;
        this.parqueadero_casa = parqueadero_casa;
        this.descripcion_casa = descripcion_casa;
        this.id_tipo_casa_casa = id_tipo_casa_casa;
    }

    public Casa(String numero_casa, Integer parqueadero_casa, String descripcion_casa, TipoCasa id_tipo_casa_casa) {
        this.numero_casa = numero_casa;
        this.parqueadero_casa = parqueadero_casa;
        this.descripcion_casa = descripcion_casa;
        this.id_tipo_casa_casa = id_tipo_casa_casa;
    }

    public Long getId_casa() {
        return id_casa;
    }

    public void setId_casa(Long id_casa) {
        this.id_casa = id_casa;
    }

    public String getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public Integer getParqueadero_casa() {
        return parqueadero_casa;
    }

    public void setParqueadero_casa(Integer parqueadero_casa) {
        this.parqueadero_casa = parqueadero_casa;
    }

    public String getDescripcion_casa() {
        return descripcion_casa;
    }

    public void setDescripcion_casa(String descripcion_casa) {
        this.descripcion_casa = descripcion_casa;
    }

    public TipoCasa getId_tipo_casa_casa() {
        return id_tipo_casa_casa;
    }

    public void setId_tipo_casa_casa(TipoCasa id_tipo_casa_casa) {
        this.id_tipo_casa_casa = id_tipo_casa_casa;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "id_casa=" + id_casa +
                ", numero_casa='" + numero_casa + '\'' +
                ", parqueadero_casa=" + parqueadero_casa +
                ", descripcion_casa='" + descripcion_casa + '\'' +
                ", id_tipo_casa_casa=" + id_tipo_casa_casa +
                '}';
    }
}
