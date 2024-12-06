package mk.ukim.finki.webaud.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.webaud.model.Category;
import mk.ukim.finki.webaud.model.Manufacturer;
import mk.ukim.finki.webaud.model.Product;
import mk.ukim.finki.webaud.model.exception.CategoryNotFound;
import mk.ukim.finki.webaud.model.exception.ManufacturerNotFound;
import mk.ukim.finki.webaud.repository.jpa.CategoryRepository;
import mk.ukim.finki.webaud.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.webaud.repository.jpa.ProductRepository;
import mk.ukim.finki.webaud.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ManufacturerRepository manufacturerRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
    }

    //private final InMemoryUserRepository userRepository;



    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
       return this.productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(String name, Double price, Integer quantity,
                                  Long categoryId, Long manufacturerId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFound(categoryId));
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(()->new ManufacturerNotFound(manufacturerId));
            this.productRepository.deleteByName(name);
        return Optional.of(this.productRepository.save(new Product(name, price, quantity, category, manufacturer)));


    }
//    public Optional<Product> save(String name, Double price, Integer quantity,
//                                  Long categoryId, Long manufacturerId) {
//        Category category= this.categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFound(categoryId))//getCategory();
//        Manufacturer manufacturer=this.manufacturerRepository.findById(manufacturerId).orElseThrow(()->new ManufacturerNotFound(manufacturerId));
//        return this.productRepository.save(name,price,quantity,category,manufacturer);
//    }
    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
