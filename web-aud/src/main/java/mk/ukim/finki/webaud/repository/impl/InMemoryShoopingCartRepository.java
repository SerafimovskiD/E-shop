package mk.ukim.finki.webaud.repository.impl;

import mk.ukim.finki.webaud.bootstrap.DataHolder;
import mk.ukim.finki.webaud.model.ShoppingCart;
import mk.ukim.finki.webaud.model.enume.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryShoopingCartRepository {
//    public Optional<ShoppingCart> findById(Long id) {
//        return DataHolder.shoppingCarts.stream().filter(i -> i.getId().equals(id)).findFirst();
//    }
    public Optional<ShoppingCart> findById(Long id) {
        return DataHolder.shoppingCarts.stream()
                .filter(cart -> Objects.equals(cart.getId(), id))
                .findFirst();
    }

    public Optional<ShoppingCart> findByUsernameAndSatus(String username, ShoppingCartStatus status) {
        return DataHolder.shoppingCarts.stream().filter(r->r.getUser().getUsername().equals(username)&&r.getStatus().equals(status)).findFirst();

    }
    public ShoppingCart save(ShoppingCart shoppingCart){
        DataHolder.shoppingCarts.removeIf(r->r.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }


}
