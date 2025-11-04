package com.mikeldi.dam.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura {

    public enum EstadoCobro {
        PENDIENTE,
        COBRADA,
        VENCIDA
    }

    private Long id;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private BigDecimal totalSinImpuestos;
    private BigDecimal totalIva;
    private BigDecimal totalConImpuestos;
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

