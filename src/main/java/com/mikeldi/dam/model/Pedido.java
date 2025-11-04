package com.mikeldi.dam.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {

    public enum EstadoPedido {
        PENDIENTE,
        PAGADO,
        ENVIADO,
        CANCELADO
    }

    private Long id;
    private LocalDateTime fechaPedido;
    private EstadoPedido estado;
    private BigDecimal totalSinImpuestos;
    private BigDecimal totalIva;
    private BigDecimal totalConImpuestos;
    private LocalDateTime fechaActualizacion;

    public Pedido() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
