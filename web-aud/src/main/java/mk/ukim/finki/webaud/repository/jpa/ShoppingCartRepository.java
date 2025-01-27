package mk.ukim.finki.webaud.repository.jpa;

import mk.ukim.finki.webaud.model.ShoppingCart;
import mk.ukim.finki.webaud.model.User;
import mk.ukim.finki.webaud.model.enume.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long>{

    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
