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
    private String fechaRegistro;

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

    public Usuario(Long id, String nombre, Avatar avatar, List<Recompensa> recompensas, List<UsuarioItem> usuarioItems, List<Meta> metas, List<Tarea> tareas, List<Movimiento> movimientos, String fechaRegistro, String contrasena, String email) {
        this.id = id;
        this.nombre = nombre;
        this.avatar = avatar;
        this.recompensas = recompensas;
        this.usuarioItems = usuarioItems;
        this.metas = metas;
        this.tareas = tareas;
        this.movimientos = movimientos;
        this.fechaRegistro = fechaRegistro;
        this.contrasena = contrasena;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(List<Recompensa> recompensas) {
        this.recompensas = recompensas;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", avatar=" + avatar +
                ", recompensas=" + recompensas +
                ", movimientos=" + movimientos +
                ", tareas=" + tareas +
                ", metas=" + metas +
                ", usuarioItems=" + usuarioItems +
                '}';
    }
}