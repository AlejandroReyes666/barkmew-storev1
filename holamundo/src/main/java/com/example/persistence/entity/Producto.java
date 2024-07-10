package com.example.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="productos")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProducto;

    @Column(name="nombre")
    private String nombre;

    @Column(name="id_categoria")
    private String idCategoria;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="precio_venta")
    private Double precioVenta;

    @Column(name="cantidad_stock")
    private Integer catidadStock;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_categoria", insertable = false,updatable = false)
    private Categoria categoria;

}
