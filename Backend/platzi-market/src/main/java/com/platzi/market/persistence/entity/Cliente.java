package com.platzi.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String apellido;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electrinico")
    private String correoElectronico;
}
