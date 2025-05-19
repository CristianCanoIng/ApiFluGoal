package com.example.FluGoal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;  // Ingreso /Egreso /Ahorro /IngresoMeta
    private double monto;
    private LocalDate fecha;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "presupuesto_id", nullable = true)
    private Meta presupuesto;

    public Movimiento() {
    }

    public Movimiento(Long id, String tipo, double monto, LocalDate fecha, String descripcion, Usuario usuario, Meta presupuesto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.presupuesto = presupuesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Meta getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Meta presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", usuario=" + usuario +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
