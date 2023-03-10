package com.pablo.market.persistence.crud;

import com.pablo.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Native query
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)

    //Query method
    List<Producto> findbyIdCategoriaOrderByNombreASC(int idCategoria);

    Optional<List<Producto>>findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
