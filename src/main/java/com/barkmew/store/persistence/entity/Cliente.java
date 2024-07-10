package com.barkmew.store.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "clientes")


public class Cliente {

    @Id
    private String id;

    private String nombre;
    private String apellidos;
    private Double celular;
    private String direccion;

    @Column(name ="correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}
