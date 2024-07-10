package com.example.persistence.crud;

import com.example.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository <Producto,Integer> {
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdcategoriaOrdeByNombreAsc(int idCategoria);

    Optional <List<Producto>> findByCantidadStockLessThanAndEstado (int cantidadStok,boolean estado);
}
