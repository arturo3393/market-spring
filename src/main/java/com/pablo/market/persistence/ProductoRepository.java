package com.pablo.market.persistence;

import com.pablo.market.persistence.crud.ProductoCrudRepository;
import com.pablo.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    //Calling the query methods
    public List<Producto> getByCategoria (int idCategoria){
        return productoCrudRepository.findbyIdCategoriaOrderByNombreASC(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
