package com.example.FluGoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double montoTotal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movimiento> movimientos;

    public Meta() {
    }

    public Meta(Long id, String nombre, double montoTotal, LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario, List<Movimiento> movimientos) {
        this.id = id;
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.movimientos = movimientos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", montoTotal=" + montoTotal +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", usuario=" + usuario +
                ", movimientos=" + movimientos +
                '}';
    }
}
