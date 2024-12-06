package mk.ukim.finki.webaud.repository.impl;

import mk.ukim.finki.webaud.bootstrap.DataHolder;
import mk.ukim.finki.webaud.model.Category;
import mk.ukim.finki.webaud.model.Manufacturer;
import mk.ukim.finki.webaud.model.Product;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepository {
    public List<Product> findAll(){
        return DataHolder.products;
    }
    public Optional<Product> findByName(String name){
        return DataHolder.products.stream().filter(r->r.getName().equals(name)).findFirst();
    }
    public Optional<Product> findById(Long id){
        return DataHolder.products.stream().filter(r->r.getId().equals(id)).findFirst();
    }
    public Optional<Product> save(String name, Double price, Integer quantity, Category category, Manufacturer manufacturer){
        DataHolder.products.removeIf(i->i.getName().equals(name));
        Product product = new Product(name,price,quantity,category,manufacturer);
        DataHolder.products.add(product);
        return Optional.of(product);
    }
    public void deleteById(Long id){
        DataHolder.products.removeIf(r->r.getId().equals(id));
    }
}