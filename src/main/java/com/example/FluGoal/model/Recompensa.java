package com.example.FluGoal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // tarea / login
    private int valor;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Recompensa() {
    }

    public Recompensa(Long id, Usuario usuario, LocalDate fecha, int valor, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.valor = valor;
        this.tipo = tipo;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Recompensa{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                '}';
    }
}
