package com.example.FluGoal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UsuarioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private TiendaItem item;

    private LocalDate fechaCompra;

    public UsuarioItem() {
    }

    public UsuarioItem(Long id, TiendaItem item, Usuario usuario, LocalDate fechaCompra) {
        this.id = id;
        this.item = item;
        this.usuario = usuario;
        this.fechaCompra = fechaCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TiendaItem getItem() {
        return item;
    }

    public void setItem(TiendaItem item) {
        this.item = item;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "UsuarioItem{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", item=" + item +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
