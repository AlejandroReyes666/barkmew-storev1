package com.example.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter

public class CompraProductoPK implements Serializable {
    @Column(name="id_compra")
    private Integer IdCompra;

    @Column(name="id_producto")
    private  Integer idProducto;
}
