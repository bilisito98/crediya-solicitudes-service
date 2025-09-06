package co.com.crediya.solicitudes.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Solicitud {

    private UUID id;
    private UUID clienteId;
    private String documentoIdentidad;
    private String numero;
    private Double monto;
    private Integer plazoMeses;
    private String tipoPrestamo;
    private String estado;
    private LocalDate fecha;
    private UUID usuarioId;

    public Solicitud(UUID id, UUID clienteId, String documentoIdentidad, String numero,
                     Double monto, Integer plazoMeses, String tipoPrestamo,
                     String estado, LocalDate fecha, UUID usuarioId) {
        this.id = id;
        this.clienteId = clienteId;
        this.documentoIdentidad = documentoIdentidad;
        this.numero = numero;
        this.monto = monto;
        this.plazoMeses = plazoMeses;
        this.tipoPrestamo = tipoPrestamo;
        this.estado = estado;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(Integer plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }
}
