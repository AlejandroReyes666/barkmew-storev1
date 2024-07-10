package com.example.persistence.mapper;

import com.example.domain.Category;
import com.example.domain.Product;
import com.example.persistence.entity.Categoria;
import com.example.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "producto_id", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "is_categoria", target = "categoryId"),
            @Mapping(source = "precio_venta", target = "price"),
            @Mapping(source = "cantidad_stock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toproduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);

}
