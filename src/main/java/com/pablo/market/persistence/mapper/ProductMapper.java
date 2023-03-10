package com.pablo.market.persistence.mapper;

import com.pablo.market.domain.Product;
import com.pablo.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source ="idProducto",target = "productId" ),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId" ),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),

    })
    Producto toProduct (Producto producto);

    List<Product> toProducts (List<Producto> productos);
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProduct (Product product);
}
