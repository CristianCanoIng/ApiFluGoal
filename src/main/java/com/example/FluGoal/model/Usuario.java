package com.example.FluGoal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String email;
    private String contrasena;
    private LocalDate fechaRegistro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Avatar avatar;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recompensa> recompensas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movimiento> movimientos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Meta> metas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioItem> usuarioItems;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String email, LocalDate fechaRegistro, String contrasena, Avatar avatar, List<Recompensa> recompensas, List<Meta> metas, List<Movimiento> movimientos, List<Tarea> tareas, List<UsuarioItem> usuarioItems) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.contrasena = contrasena;
        this.avatar = avatar;
        this.recompensas = recompensas;
        this.metas = metas;
        this.movimientos = movimientos;
        this.tareas = tareas;
        this.usuarioItems = usuarioItems;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(List<Recompensa> recompensas) {
        this.recompensas = recompensas;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public List<UsuarioItem> getUsuarioItems() {
        return usuarioItems;
    }

    public void setUsuarioItems(List<UsuarioItem> usuarioItems) {
        this.usuarioItems = usuarioItems;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", avatar=" + avatar +
                ", recompensas=" + recompensas +
                ", movimientos=" + movimientos +
                ", tareas=" + tareas +
                ", metas=" + metas +
                ", usuarioItems=" + usuarioItems +
                '}';
    }
}
