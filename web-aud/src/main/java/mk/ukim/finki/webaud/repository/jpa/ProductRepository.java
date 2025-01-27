package mk.ukim.finki.webaud.repository.jpa;

import mk.ukim.finki.webaud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    Optional<Product>findByName(String name);
    void deleteByName(String name);
}
