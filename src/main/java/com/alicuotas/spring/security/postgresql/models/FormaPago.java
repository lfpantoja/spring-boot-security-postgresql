package com.alicuotas.spring.security.postgresql.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table( name = "forma_pago")
public class FormaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_forma_pago;

    @NotBlank
    @Size(max = 150)
    private String descripcion_forma_pago;

    @NotBlank
    @Size(max = 50)
    private String numero_forma_pago;

    @ManyToOne
    @JoinColumn(name = "id_entidad_bancaria_forma_pago")
    private EntidadBancaria id_entidad_bancaria_forma_pago;

    public FormaPago() {
    }

    public FormaPago(Long id_forma_pago, String descripcion_forma_pago, String numero_forma_pago, EntidadBancaria id_entidad_bancaria_forma_pago) {
        this.id_forma_pago = id_forma_pago;
        this.descripcion_forma_pago = descripcion_forma_pago;
        this.numero_forma_pago = numero_forma_pago;
        this.id_entidad_bancaria_forma_pago = id_entidad_bancaria_forma_pago;
    }

    public FormaPago(String descripcion_forma_pago, String numero_forma_pago, EntidadBancaria id_entidad_bancaria_forma_pago) {
        this.descripcion_forma_pago = descripcion_forma_pago;
        this.numero_forma_pago = numero_forma_pago;
        this.id_entidad_bancaria_forma_pago = id_entidad_bancaria_forma_pago;
    }

    public Long getId_forma_pago() {
        return id_forma_pago;
    }

    public void setId_forma_pago(Long id_forma_pago) {
        this.id_forma_pago = id_forma_pago;
    }

    public String getDescripcion_forma_pago() {
        return descripcion_forma_pago;
    }

    public void setDescripcion_forma_pago(String descripcion_forma_pago) {
        this.descripcion_forma_pago = descripcion_forma_pago;
    }

    public String getNumero_forma_pago() {
        return numero_forma_pago;
    }

    public void setNumero_forma_pago(String numero_forma_pago) {
        this.numero_forma_pago = numero_forma_pago;
    }

    public EntidadBancaria getId_entidad_bancaria_forma_pago() {
        return id_entidad_bancaria_forma_pago;
    }

    public void setId_entidad_bancaria_forma_pago(EntidadBancaria id_entidad_bancaria_forma_pago) {
        this.id_entidad_bancaria_forma_pago = id_entidad_bancaria_forma_pago;
    }
}
