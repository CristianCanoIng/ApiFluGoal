package com.example.FluGoal.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class TiendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // fondo / icono / tema
    private int precio;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioItem> usuariosQueLoCompraron;

    public TiendaItem() {
    }

    public TiendaItem(Long id, String nombre, String tipo, int precio, List<UsuarioItem> usuariosQueLoCompraron) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.usuariosQueLoCompraron = usuariosQueLoCompraron;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<UsuarioItem> getUsuariosQueLoCompraron() {
        return usuariosQueLoCompraron;
    }

    public void setUsuariosQueLoCompraron(List<UsuarioItem> usuariosQueLoCompraron) {
        this.usuariosQueLoCompraron = usuariosQueLoCompraron;
    }

    @Override
    public String toString() {
        return "TiendaItem{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", usuariosQueLoCompraron=" + usuariosQueLoCompraron +
                '}';
    }
}
