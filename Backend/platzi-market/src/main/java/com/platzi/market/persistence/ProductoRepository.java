package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository _productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) _productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory( int categoryId) {
        List<Producto> productos = _productoCrudRepository.findByCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = _productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, false);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return  _productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(_productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId){
        _productoCrudRepository.deleteById(productId);
    }

}
