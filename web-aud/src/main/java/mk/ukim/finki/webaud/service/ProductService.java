package mk.ukim.finki.webaud.service;

import mk.ukim.finki.webaud.model.Category;
import mk.ukim.finki.webaud.model.Manufacturer;
import mk.ukim.finki.webaud.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    Optional<Product>findById(Long id);
    Optional<Product>findByName(String name);
    Optional<Product> save(String name, Double price, Integer quantity, Long categoryId,Long manufacturerId);
    void deleteById(Long id);

}
