package com.example.persistence;

import com.example.domain.Product;
import com.example.domain.repository.ProductRepository;
import com.example.persistence.crud.ProductCrudRepository;
import com.example.persistence.entity.Producto;
import com.example.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productCrudRepository.findByIdcategoriaOrdeByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScareproducts(int quantity) {
        Optional <List<Producto>> productos= productCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }


    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toproduct(ProductCrudRepository.save(producto));
    }


    public Producto save(Producto producto) {

    }

    public void delete(int idproducto) {
        productCrudRepository.deleteById(idproducto);
    }

}
