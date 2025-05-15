package com.example.FluGoal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private boolean completada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarea() {
    }

    public Tarea(Long id, String titulo, String descripcion, LocalDate fechaCreacion, boolean completada, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.completada = completada;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", completada=" + completada +
                ", usuario=" + usuario +
                '}';
    }
}
