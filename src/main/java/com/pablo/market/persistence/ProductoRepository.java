package com.pablo.market.persistence;

import com.pablo.market.domain.Product;
import com.pablo.market.domain.respository.ProductRepository;
import com.pablo.market.persistence.crud.ProductoCrudRepository;
import com.pablo.market.persistence.entity.Producto;
import com.pablo.market.persistence.mapper.ProductMapper;
import org.springframework.expression.spel.ast.OpPlus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos =  productoCrudRepository.findbyIdCategoriaOrderByNombreASC(categoryId);
        return Optional.of(mapper.toProducts(productos));

    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos =productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<U> u = productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
        return u;
    }
    @Override
    public Product save(Product product) {
        return null;
    }

    //Calling the query methods




    public Producto save (Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete (int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
