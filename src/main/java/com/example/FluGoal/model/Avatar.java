package com.example.FluGoal.model;

import jakarta.persistence.*;

@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estilo;
    private String fondo;
    private String color;
    private String icono;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Avatar() {
    }

    public Avatar(Long id, String estilo, String fondo, String color, String icono, Usuario usuario) {
        this.id = id;
        this.estilo = estilo;
        this.fondo = fondo;
        this.color = color;
        this.icono = icono;
        this.usuario = usuario;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "id=" + id +
                ", estilo='" + estilo + '\'' +
                ", fondo='" + fondo + '\'' +
                ", color='" + color + '\'' +
                ", icono='" + icono + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
