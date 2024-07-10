package com.example.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="compras_producto")
@Getter
@Setter

public class ComprasProducto {
    @EmbeddedId
    private  CompraProductoPK id;

    private Integer cantidad;

    private Double total;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_compra",insertable = false,updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name="id_producto" ,insertable=false, updatable = false)
    private Producto producto;

}
