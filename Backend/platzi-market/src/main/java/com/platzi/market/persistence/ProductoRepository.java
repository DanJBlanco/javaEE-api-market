package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository _productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) _productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria( int idCategoria) {
        return _productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return _productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, false);
    }

    public Optional<Producto> getProducto(int idProducto){
        return _productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return _productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        _productoCrudRepository.deleteById(idProducto);
    }

}
