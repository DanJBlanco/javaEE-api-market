package com.platzi.market.persistence.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String nombre;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private boolean estado;
}
