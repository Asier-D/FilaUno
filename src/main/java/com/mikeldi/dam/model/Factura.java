package com.mikeldi.dam.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {

    public enum EstadoCobro {
        PENDIENTE,
        COBRADA,
        VENCIDA
    }

    @Id
    private Long id;
    @Column
    private String numeroFactura;
    @Column
    private LocalDateTime fechaEmision;
    @Column
    private BigDecimal totalSinImpuestos;
    @Column
    private BigDecimal totalIva;
    @Column
    private BigDecimal totalConImpuestos;
    @Column
    private EstadoCobro estadoCobro;

    public Factura() {
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    public BigDecimal getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(BigDecimal totalIva) {
        this.totalIva = totalIva;
    }

    public BigDecimal getTotalConImpuestos() {
        return totalConImpuestos;
    }

    public void setTotalConImpuestos(BigDecimal totalConImpuestos) {
        this.totalConImpuestos = totalConImpuestos;
    }

    public EstadoCobro getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(EstadoCobro estadoCobro) {
        this.estadoCobro = estadoCobro;
    }
}

